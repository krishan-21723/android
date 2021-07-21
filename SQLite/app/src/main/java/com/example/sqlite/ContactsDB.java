package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ContactsDB {

    private static final String KEY_ROW_ID = "_id";
    private static final String KEY_ROW_NAME = "person_name";
    private static final String KEY_ROW_CELL = "_cell";

    private final String DATABASE_NAME = "ContactsDB.db";
    private final String DATABASE_TABLE = "ContactsTable";
    private final int DATABASE_VERSION = 1;

    private DBHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    public ContactsDB(Context context) {
        this.ourContext = context;
    }

    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String sqlCode = "CREATE TABLE " + DATABASE_TABLE + " (" +
                    KEY_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_ROW_NAME + " TEXT NOT NULL, " +
                    KEY_ROW_CELL + " TEXT NOT NULL);";
            db.execSQL(sqlCode);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public ContactsDB open() throws SQLException {
        ourHelper = new DBHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        ourHelper.close();
    }

    public long createEntry(String name, String cell) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ROW_NAME, name);
        cv.put(KEY_ROW_CELL, cell);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }

    public String getData() {
        String[] columns = {KEY_ROW_ID, KEY_ROW_NAME, KEY_ROW_CELL};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";
        int iRowID = c.getColumnIndex(KEY_ROW_ID);
        int iRowName = c.getColumnIndex(KEY_ROW_NAME);
        int iRowCell = c.getColumnIndex(KEY_ROW_CELL);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iRowID) + ": " + c.getString(iRowName) + " " + c.getString(iRowCell) + "\n";
        }
        c.close();
        return result;
    }

    public long deleteEntry(String rowId) {
        return ourDatabase.delete(DATABASE_TABLE, KEY_ROW_ID + "=?", new String[]{rowId});
    }

    public long updateEntry(String rowId, String name, String cell) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_ROW_NAME, name);
        cv.put(KEY_ROW_CELL, cell);
        return ourDatabase.update(DATABASE_TABLE, cv, KEY_ROW_ID + "=?", new String[]{rowId});
    }

}
