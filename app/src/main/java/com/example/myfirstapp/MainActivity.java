package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
        LinearLayout linearLayoutVertical = binding.linearLayoutVertical;

        for (int i = 0; i < 20; i++) {
            int imgId = getResources().getIdentifier("dog2", "drawable", getPackageName());
            Drawable image = getDrawable(imgId);



            ImageView imgView = new ImageView(this);
            imgView.setImageDrawable(image);
            imgView.setId(i + 1);
            imgView.setPadding(0, 0, 0, 5);

            linearLayoutVertical.addView(imgView);


            //TextView textView = new TextView(this);
            //textView.setText("TextView :" + String.valueOf(i));
            //linearLayoutVertical.addView(textView);
        }

        // Dynamically add Image Views to layout (vertical)
        LinearLayout linearLayoutHorizontal = binding.linearLayoutHorizontal;

        for (int i = 0; i < 20; i++) {
            //TextView textView = new TextView(this);
            //textView.setText("TextView :" + String.valueOf(i));
            //linearLayoutHorizontal.addView(textView);
            int imgId = getResources().getIdentifier("dog3", "drawable", getPackageName());
            Drawable image = getDrawable(imgId);

            ImageView imgView = new ImageView(this);
            imgView.setImageDrawable(image);
            imgView.setId(i + 1);
            imgView.setPadding(0, 0, 0, 5);

            linearLayoutHorizontal.addView(imgView);

        }

        // Handle Button Click Event
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TESTING", "Button Submit Clicked");
                Log.i("TESTING", "Name: " + binding.editTextName.getText().toString());

                String message = "Welcome " + binding.editTextName.getText().toString() +
                        " " + binding.editLastName.getText().toString();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();

            }
        });

    }
}