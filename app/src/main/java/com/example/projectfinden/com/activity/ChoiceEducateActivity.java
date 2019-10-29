package com.example.projectfinden.com.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.projectfinden.R;
import com.google.android.material.bottomappbar.BottomAppBar;

public class ChoiceEducateActivity extends AppCompatActivity {
    ImageView imageView;
    ImageView imageViewGuide;
    BottomAppBar bottomAppBar;
//    ImageView imageViewStudy;
//    ImageView imageViewCall;
//    ImageView imageViewPerson;
//    ImageView imageViewAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_choice_educate);
        imageView=findViewById(R.id.image);
//        bottomAppBar= findViewById(R.id.bottomAppBar);
        imageView=findViewById(R.id.image);
        String url="https://firebasestorage.googleapis.com/v0/b/projectfinden.appspot.com/o/logoFinden.png?alt=media&token=875e505a-3dd5-4074-ad22-0a49c0205dba";
        Glide.with(getApplicationContext()).load(url).into(imageView);

}}
