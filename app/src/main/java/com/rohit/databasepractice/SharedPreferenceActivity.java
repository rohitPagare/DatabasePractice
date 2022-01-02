package com.rohit.databasepractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferenceActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtv_file,edtKey,edtValue,edtGetKey,edtv_getfile;
    private Button btnSave,btnShow;
    private TextView tvValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference);

        edtv_file = findViewById(R.id.edtv_file);
        edtKey = findViewById(R.id.edtv_key);
        edtValue = findViewById(R.id.edtv_value);
        edtGetKey = findViewById(R.id.edtv_getkey);
        btnSave = findViewById(R.id.btn_save);
        btnShow = findViewById(R.id.btn_show);
        tvValue = findViewById(R.id.textView);
        edtv_getfile = findViewById(R.id.edtv_getfile);

        btnSave.setOnClickListener(this);
        btnShow.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save:save();
                break;
            case R.id.btn_show:show();
                break;
            default:
                break;
        }
    }

    private void save(){
        MySharedPreference msp = new MySharedPreference(SharedPreferenceActivity.this);
        String filename = edtv_file.getText().toString();
        String key = edtKey.getText().toString();
        String value = edtValue.getText().toString();

        if(key.isEmpty()){
            Toast.makeText(SharedPreferenceActivity.this, "Key Should Not Empty", Toast.LENGTH_SHORT).show();
        }else if(filename.isEmpty()){
            msp.saveStringToDefault(key,value);
        }else{
            msp.saveStringToCustomPreference(filename,key,value);
        }
        edtv_file.getText().clear();
        edtKey.getText().clear();
        edtValue.getText().clear();
    }

    private void show(){
        MySharedPreference msp = new MySharedPreference(SharedPreferenceActivity.this);
        String filename = edtv_getfile.getText().toString();
        String key = edtGetKey.getText().toString();

        String value=null;

        if(key.isEmpty()){
            Toast.makeText(SharedPreferenceActivity.this, "Key Should Not Empty", Toast.LENGTH_SHORT).show();
        }else if(filename.isEmpty()){
             value = msp.getStringFromDefault(key);
        }else{
             value = msp.getStringFromCustomPreference(filename,key);
        }

        tvValue.setText(value);

        edtv_getfile.getText().clear();
        edtGetKey.getText().clear();

    }
}