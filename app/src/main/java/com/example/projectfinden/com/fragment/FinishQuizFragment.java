package com.example.projectfinden.com.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projectfinden.R;
import com.example.projectfinden.com.adapter.CustomAdapterShowPerson;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinishQuizFragment extends Fragment {
    private ListView listView;
    private TextView tvResult;
    private Button buttonBack;
    private static CustomAdapterShowPerson adapter;

    public FinishQuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_finish_quiz,container,false);
        listView= view.findViewById(R.id.listViewQuestion);
        buttonBack= view.findViewById(R.id.buttonBack);
        tvResult=view.findViewById(R.id.textViewResult);
        tvResult.setText((QuizletFragment.correctAnswerCount/QuizletFragment.questionList.size())*100 +"%");
        adapter=new CustomAdapterShowPerson(QuizletFragment.questionList,getActivity());
        listView.setAdapter(adapter);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr= getFragmentManager().beginTransaction();
                fr.replace(R.id.frameLayoutMenu,new FragmentTopicEducate(2));
                fr.commit();
                return;
            }
        });
        return view;
    }

}
