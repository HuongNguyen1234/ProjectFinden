package com.example.projectfinden.com.fragment;


import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectfinden.R;
import com.example.projectfinden.com.Interface.IFirebaseLoadDone;
import com.example.projectfinden.com.adapter.MyAdapter;
import com.example.projectfinden.com.model.Option;
import com.example.projectfinden.com.model.Question;
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
public class QuizletFragment extends Fragment implements IFirebaseLoadDone, ValueEventListener {
    private String topic;
    public static List<Question> questionList = new ArrayList<>();
    DatabaseReference ref;
    IFirebaseLoadDone iFirebaseLoadDone;
    Button buttonA,buttonB,buttonC,buttonD,buttonTiepTucSai,buttonTiepTucDung;
    TextView textViewQuestion,textViewA,textViewB,textViewC,textViewD,textQuestion,textA,textB,textC,textD,textAnswer;
    int idAnswer=0;
    int i=0;
    public static int correctAnswerCount = 0;


    public QuizletFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_quizlet, container, false);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("/").child("FirstAidInstructions").child("fainting").child("quizlet").child("question");
        buttonA=view.findViewById(R.id.buttonA);
        buttonB=view.findViewById(R.id.buttonB);
        buttonC=view.findViewById(R.id.buttonC);
        buttonD=view.findViewById(R.id.buttonD);

        textViewQuestion=view.findViewById(R.id.textViewQuestion);
        textViewA=view.findViewById(R.id.textViewA);
        textViewB=view.findViewById(R.id.textViewB);
        textViewC=view.findViewById(R.id.textViewC);
        textViewD=view.findViewById(R.id.textViewD);
        iFirebaseLoadDone= (IFirebaseLoadDone) this;
        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                buttonA.setBackground(Drawable.createFromPath("#1A74B8"));
                onButtonClickDo(1);
            }
        });
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                buttonB.setBackground(Drawable.createFromPath("#1A74B8"));
                onButtonClickDo(2);
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                buttonC.setBackground(Drawable.createFromPath("#1A74B8"));
                onButtonClickDo(3);
            }
        });
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                buttonD.setBackground(Drawable.createFromPath("#1A74B8"));
                onButtonClickDo(4);
            }
        });
        return view;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        Iterable<DataSnapshot> s=dataSnapshot.getChildren();
        for (DataSnapshot movieSnapShot:dataSnapshot.getChildren())
            this.questionList.add(movieSnapShot.getValue(Question.class));
        iFirebaseLoadDone.onFirebaseLoadSuccessQuestion(this.questionList);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    @Override
    public void onFirebaseLoadSuccessQuestion(final List<Question> questionList) {
        if (questionList == null || questionList.isEmpty()) {
            textViewA.setText("Does not have any questions!");
            return;
        }
        final Question question= questionList.get(i);
        textViewQuestion.setText(question.getNumber()+": "+ question.getContent());
        textViewA.setText(question.getOptions().get(0).getValue());
        textViewB.setText(question.getOptions().get(1).getValue());
        textViewC.setText(question.getOptions().get(2).getValue());
        textViewD.setText(question.getOptions().get(3).getValue());

        for(Option option : question.getOptions()){
            if(option.isAnswer()==true){
                idAnswer= option.getId();
                return;
            }
        }

    }
    public void setText(){
        if(idAnswer==1){
            textAnswer.setText("A");
        }else if(idAnswer==2){
            textAnswer.setText("B");
        }
        else if(idAnswer==3){
            textAnswer.setText("C");
        }
        else if(idAnswer==4){
            textAnswer.setText("D");
        }
    }

    @Override
    public void onFirebaseLoadSuccess(List<Step> movieList) {
        ;
    }

    @Override
    public void onFirebaseLoadFailed(String message) {

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

    public void onButtonClickDo(int num) {
        Button continueBtn = null;
        final Dialog dialog= new Dialog(getContext());
        if(idAnswer == num){
            dialog.setContentView(R.layout.dialog_check_question_correct);
            correctAnswerCount++;
            continueBtn = dialog.findViewById(R.id.buttonTiepTucDung);
            i++;
            continueBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                    doContinueClick();
                }
            });
            dialog.show();
        }
        else{
            dialog.setContentView(R.layout.dialog_check_question_error);
            final Question question= questionList.get(i);
            TextView mainTitle = dialog.findViewById(R.id.tvTitle);
            mainTitle.setText(" SAI");
            TextView tvQuestionContent = dialog.findViewById(R.id.tvQuestionContent);
            TextView tvA = dialog.findViewById(R.id.tvA);
            TextView tvB = dialog.findViewById(R.id.tvB);
            TextView tvC = dialog.findViewById(R.id.tvC);
            TextView tvD = dialog.findViewById(R.id.tvD);
            TextView tvCorrectAnswer = dialog.findViewById(R.id.tvCorrectAnswer);
            continueBtn = dialog.findViewById(R.id.buttonTiepTucSai);
            tvQuestionContent.setText(question.getNumber() == null ? "" : question.getNumber() + ": " + question.getContent() == null ? "" : question.getContent());
            tvA.setText(question.getOptions().get(0).getValue());
            tvB.setText(question.getOptions().get(1).getValue());
            tvC.setText(question.getOptions().get(2).getValue());
            tvD.setText(question.getOptions().get(3).getValue());
            for(Option option : question.getOptions()){
                if(option.isAnswer()==true){
                    tvCorrectAnswer.setText(option.getValue() == null ? "" : option.getValue());
                }
            }
            i++;
            continueBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.cancel();
                    doContinueClick();
                }
            });
            dialog.show();
        }
    }
    public void doContinueClick() {
        if (i > questionList.size() - 1) {
            FragmentTransaction fr= getFragmentManager().beginTransaction();
            fr.replace(R.id.frameLayoutMenu,new FinishQuizFragment());
            fr.commit();
            return;
        }
        final Question question= questionList.get(i);
        textViewQuestion.setText(question.getNumber()+": "+ question.getContent());
        textViewA.setText(question.getOptions().get(0).getValue());
        textViewB.setText(question.getOptions().get(1).getValue());
        textViewC.setText(question.getOptions().get(2).getValue());
        textViewD.setText(question.getOptions().get(3).getValue());

        for(Option option : question.getOptions()){
            if(option.isAnswer()==true){
                idAnswer= option.getId();
                break;
            }
        }
    }
}
