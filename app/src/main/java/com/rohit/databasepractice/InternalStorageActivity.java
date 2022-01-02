package com.rohit.databasepractice;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class InternalStorageActivity extends AppCompatActivity {

    EditText edtv_filename,edtv_details,edtv_getfilename;
    Button btn_save,btn_read;
    TextView tvread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstorage);

        edtv_filename = findViewById(R.id.edtv_filename);
        edtv_details = findViewById(R.id.edtv_details);
        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(view -> save());

        edtv_getfilename = findViewById(R.id.edtv_getfilename);
        btn_read = findViewById(R.id.btn_read);
        tvread = findViewById(R.id.tvread);

        btn_read.setOnClickListener(view ->read());

    }

    private void save(){
        String filename = edtv_filename.getText().toString();
        String details = edtv_details.getText().toString();

        if(filename.isEmpty()){
            Toast.makeText(InternalStorageActivity.this, "Filename should not empty", Toast.LENGTH_SHORT).show();
        }else {
            try {
                FileOutputStream fos = openFileOutput(filename,MODE_PRIVATE);
                fos.write(details.getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        edtv_filename.getText().clear();
        edtv_details.getText().clear();

    }

    private void read(){
        String filename = edtv_getfilename.getText().toString();
        if(filename.isEmpty()){
            Toast.makeText(InternalStorageActivity.this, "Filename should not empty", Toast.LENGTH_SHORT).show();
        }else {
            try {
                FileInputStream fis = openFileInput(filename);
                Scanner scanner = new Scanner(fis);
                scanner.useDelimiter("\\z");
                String s = scanner.next();
                scanner.close();
                tvread.setText(s);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}