package com.example.projectfinden.com.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.projectfinden.R;


public class FragmentChoiceEducate extends Fragment {
    Button buttonStudy;
    Button buttonQuizlet;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_choice_educate,container,false);
        buttonStudy= view.findViewById(R.id.buttonStudyEducate);
       buttonQuizlet=view.findViewById(R.id.buttonGame);
       buttonStudy.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FragmentTransaction fr= getFragmentManager().beginTransaction();
               fr.replace(R.id.frameLayoutMenu,new FragmentTopicEducate());
               fr.commit();
           }
       });
       return view;
    }


}
