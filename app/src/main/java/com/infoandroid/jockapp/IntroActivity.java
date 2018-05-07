package com.infoandroid.jockapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.infoandroid.jockapp.sharepreference.AppSharedPreference;
import com.infoandroid.jockapp.util.Constants;

public class IntroActivity extends AppCompatActivity {
 private Button btnSubmit;
 private TextInputEditText edtName;
 private TextInputEditText edtLastName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        edtName= findViewById(R.id.edtName);
        edtLastName= findViewById(R.id.edtLastName);
        btnSubmit= findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edtName.getText().toString();
                String lastName = edtLastName.getText().toString();
                if (name.equals("") && name.equals(null)){
                    Toast.makeText(IntroActivity.this,"fill Name ",Toast.LENGTH_SHORT).show();
                }else if(lastName.equals("") && lastName.equals(null)){
                    Toast.makeText(IntroActivity.this,"fill Last Name ",Toast.LENGTH_SHORT).show();
                }else {
                    AppSharedPreference.putString(Constants.NAME_KEY, name, IntroActivity.this);
                    AppSharedPreference.putString(Constants.LAST_NAME_KEY, lastName, IntroActivity.this);
                    startActivity(new Intent(IntroActivity.this,MasterActivity.class));
                }

            }
        });
    }
}
