package com.application.week4cloudtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.application.week4cloudtutorial.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {



    SharedPreferences returnShared;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);


        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        returnShared = getSharedPreferences("MY_PREF", MODE_PRIVATE);
        int countFromShared = returnShared.getInt("COUNT_KEY", 0);

        binding.editTextTextPersonName.setText(String.valueOf(countFromShared));





    }
}