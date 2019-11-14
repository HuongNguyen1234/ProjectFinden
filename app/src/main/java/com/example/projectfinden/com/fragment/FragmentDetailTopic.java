package com.example.projectfinden.com.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.projectfinden.R;
import com.example.projectfinden.com.Interface.IFirebaseLoadDone;
import com.example.projectfinden.com.adapter.MyAdapter;
import com.example.projectfinden.com.model.Question;
import com.example.projectfinden.com.model.Step;
import com.example.projectfinden.com.transformer.DepthPageTransformer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FragmentDetailTopic extends Fragment implements IFirebaseLoadDone, ValueEventListener {
    ViewPager viewPager;
    MyAdapter adapter;
    List<Step> movieList = new ArrayList<>();
    DatabaseReference ref;
    IFirebaseLoadDone iFirebaseLoadDone;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_detail_topic,container,false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
         ref = database.getReference("/").child("FirstAidInstructions").child("fainting").child("studyAndGuide").child("case").child("none").child("step");
        iFirebaseLoadDone= (IFirebaseLoadDone) this;
        viewPager = view.findViewById(R.id.view_pager);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void loadMovie() {
        /*
        This is a different approach but also correct.
        movies.addListenerForSingleValueEvent(new ValueEventListener() {

            List<Movie> movieList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot movieSnapShot:dataSnapshot.getChildren())
                movieList.add(movieSnapShot.getValue(Movie.class));

                iFirebaseLoadDone.onFirebaseLoadSuccess(movieList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                iFirebaseLoadDone.onFirebaseLoadFailed(databaseError.getMessage());
            }
        });*/
        ref.addValueEventListener(this);
    }

    @Override
    public void onFirebaseLoadSuccessQuestion(List<Question> questionList) {

    }

    @Override
    public void onFirebaseLoadSuccess(List<Step> stepList) {
        adapter = new MyAdapter(getContext(),this.movieList);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onFirebaseLoadFailed(String message) {
        Toast.makeText(getContext(), ""+message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//        List<Step> movieList = new ArrayList<>();
        Iterable<DataSnapshot> s=dataSnapshot.getChildren();
        for (DataSnapshot movieSnapShot:dataSnapshot.getChildren())
            this.movieList.add(movieSnapShot.getValue(Step.class));
        iFirebaseLoadDone.onFirebaseLoadSuccess(this.movieList);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        iFirebaseLoadDone.onFirebaseLoadFailed(databaseError.getMessage());
    }
    @Override
    public void onDestroy() {
        ref.removeEventListener(this);
        super.onDestroy();
    }

    @Override
    public void onResume() {
        ref.addValueEventListener(this);
        super.onResume();
    }

    @Override
    public void onStop() {
        ref.removeEventListener(this);
        super.onStop();
    }
}
