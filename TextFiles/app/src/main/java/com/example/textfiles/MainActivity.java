package com.example.textfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    EditText etName, etSurname;
    TextView tvResults;
    List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        tvResults = findViewById(R.id.tvResults);

        persons = new ArrayList<Person>();

        loadData();
    }

    public void btnAddData(View v) {
        String name = etName.getText().toString();
        String surname = etSurname.getText().toString();

        Person person = new Person(name, surname);
        persons.add(person);
        setTextToTextView();
    }

    private void setTextToTextView() {
        String text = "";
        for (Person person : persons) {
            text = text + person.getName() + " " + person.getSurname() + "\n";
        }
        tvResults.setText(text);
    }

    public void loadData() {
        persons.clear();

        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromFile;
        if (file.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));
                lineFromFile = reader.readLine();
                while (lineFromFile != null) {
                    StringTokenizer token = new StringTokenizer(lineFromFile, ",");
                    Person person = new Person(token.nextToken(), token.nextToken());
                    persons.add(person);
                    lineFromFile = reader.readLine();
                }
                reader.close();
                setTextToTextView();
            } catch (IOException e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnSaveData(View v) {
        try {
            FileOutputStream file = openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for (Person person : persons) {
                outputFile.write(person.getName() + "," + person.getSurname() + "\n");
            }
            outputFile.flush();
            outputFile.close();
            Toast.makeText(this, "Successfully saved data", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}