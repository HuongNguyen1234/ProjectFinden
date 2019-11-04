package com.example.projectfinden.com.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.projectfinden.R;
import com.example.projectfinden.com.fragment.FragmentTopicEducate;

public class ChoiceActivity extends AppCompatActivity {
    ImageView imageView;
    Button buttonGuide;
    Button buttonEducate;
    Button buttonAbout;
    Button button115;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        imageView=findViewById(R.id.image);
        buttonGuide= findViewById(R.id.buttonStudyEducate);
        buttonEducate= findViewById(R.id.buttonEducate);
        buttonAbout= findViewById(R.id.buttonGame);
        button115= findViewById(R.id.button115);
        //show logo
        String url="https://firebasestorage.googleapis.com/v0/b/projectfinden.appspot.com/o/logoFinden.png?alt=media&token=875e505a-3dd5-4074-ad22-0a49c0205dba";
        Glide.with(getApplicationContext()).load(url).into(imageView);
        //
        buttonEducate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), MenuFragment.class);
                intent.putExtra("choice","2");
                startActivity(intent);
            }
        });
        buttonGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(v.getContext(), MenuFragment.class);
                intent.putExtra("choice","1");
                startActivity(intent);
            }
        });
        button115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
