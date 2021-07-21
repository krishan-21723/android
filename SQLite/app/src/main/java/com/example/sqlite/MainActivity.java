package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etCell = findViewById(R.id.etCell);
    }

    public void btnSubmit(View v) {
        String name = etName.getText().toString().trim();
        String cell = etCell.getText().toString().trim();

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.createEntry(name, cell);
            db.close();
            Toast.makeText(this, "Successfully Saved!!", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etCell.setText("");
        } catch (SQLException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void showData(View v) {
        startActivity(new Intent(this, Data.class));
    }

    public void editData(View v) {
        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.updateEntry("1", "krishan", "6543212345654");
            db.close();
            Toast.makeText(this, "Successfully Updated!!", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteData(View v) {
        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(this, "Successfully Deleted!!", Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}