package com.application.week4cloudtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.application.week4cloudtutorial.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    int count = 0;

    SharedPreferences sharedPreferences;

//    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);

//        sharedPreferences_another = getSharedPreferences("MY_PREF_ANOTHER", MODE_PRIVATE);
        int countFromShared = sharedPreferences.getInt("COUNT_KEY", 0);

        binding.textView.setText(String.valueOf(countFromShared));

        binding.startCounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                count += 1;
                binding.textView.setText(String.valueOf(count));

                if(binding.checkBox.isChecked()){
                    //Create Editor for the shared pReferences.

                    editor.putInt("COUNT_KEY", count);
                    editor.putString("RANDOM", "THIS IS RANDOM VALUE");
                    editor.apply();
                }

                else {
                    editor.putInt("COUNT_KEY", 0);
                    editor.putString("RANDOM", "THIS IS RANDOM VALUE");
                    editor.apply();
                }

                if(count == 5){
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }





            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("CHECKING PAUSE", "PAUSE");


    }
}