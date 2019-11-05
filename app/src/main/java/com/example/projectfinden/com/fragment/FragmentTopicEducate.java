package com.example.projectfinden.com.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projectfinden.R;

public class FragmentTopicEducate extends Fragment {
    private Button buttonBatT;
    private int option;

    public FragmentTopicEducate(int option) {
        this.option = option;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_topic_educate,container,false);
        buttonBatT= view.findViewById(R.id.buttonBatTinh);


        buttonBatT.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(option==1){
                    FragmentTransaction fr= getFragmentManager().beginTransaction();
                    fr.replace(R.id.frameLayoutMenu,new FragmentDetailTopic());
                    fr.commit();
                }
                else if(option==2){
                    FragmentTransaction fr= getFragmentManager().beginTransaction();
                    fr.replace(R.id.frameLayoutMenu,new QuizletFragment("battinh"));
                    fr.commit();
                }
            }

        });
        return view;
    }


}
