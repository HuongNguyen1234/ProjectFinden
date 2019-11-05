package com.example.projectfinden.com.fragment;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectfinden.R;
import com.example.projectfinden.com.model.Step;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizletFragment extends Fragment implements ValueEventListener {
    private String topic;
    List<Step> movieList = new ArrayList<>();
    DatabaseReference ref;
    public QuizletFragment(String topic) {
        this.topic= topic;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_quizlet, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("/").child("FirstAidInstructions").child("fainting").child("quizlet").child("question");
        return view;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
