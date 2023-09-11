package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        binding.txtWelcomeMsg.setText(R.string.welcome_message);

        // Logging
        Log.i("TESTING", "Hello Log!!");

        // Dynamically add views to layout
        LinearLayout linearLayout = binding.linearLayout;

        for (int i = 0; i < 20; i++) {
            TextView textView = new TextView(this);
            textView.setText("TextView :" + String.valueOf(i));
            linearLayout.addView(textView);

        }

        // Handle Button Click Event
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TESTING", "Button Submit Clicked");
                Log.i("TESTING", "Name: " + binding.editTextName.getText().toString());

                String message = "Welcome " + binding.editTextName.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
}