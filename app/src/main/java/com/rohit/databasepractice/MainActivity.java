package com.rohit.databasepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPreference,btnInternal,btnExternal,btnSqlLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPreference = findViewById(R.id.btnPreference);
        btnPreference.setOnClickListener(this);

        btnInternal = findViewById(R.id.btnInternal);
        btnInternal.setOnClickListener(this);

        btnExternal = findViewById(R.id.btnExternal);
        btnExternal.setOnClickListener(this);

        btnSqlLite = findViewById(R.id.btnSqlLite);
        btnSqlLite.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnPreference:startActivity(new Intent(MainActivity.this,SharedPreferenceActivity.class));
                break;
            case R.id.btnInternal:startActivity(new Intent(MainActivity.this,InternalStorageActivity.class));
                break;
            case R.id.btnExternal:
                break;
            case R.id.btnSqlLite:
                break;
            default:
                break;
        }
    }
}