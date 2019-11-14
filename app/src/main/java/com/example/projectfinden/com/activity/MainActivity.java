package com.example.projectfinden.com.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.projectfinden.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.image);
        String url="https://firebasestorage.googleapis.com/v0/b/projectfinden.appspot.com/o/logoFinden.png?alt=media&token=875e505a-3dd5-4074-ad22-0a49c0205dba";
        Glide.with(getApplicationContext()).load(url).into(imageView);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
//                Toast.makeText(this, "Release", Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(this, "Down", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(this, ChoiceActivity.class);
                startActivity(intent);
                break;

        }
        return super.onTouchEvent(event);
    }
}
