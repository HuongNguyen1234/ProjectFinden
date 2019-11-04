package com.example.projectfinden.com.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.projectfinden.R;
import com.example.projectfinden.com.entity.Step;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FragmentTopicEducate extends Fragment {
    private Button buttonBatTinh;
    private List<String> des=null;
    private List<String> urls=null;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_topic_educate,container,false);
        buttonBatTinh= view.findViewById(R.id.buttonBatTinh);

        des = new ArrayList<>();
        urls = new ArrayList<>();
//        urls.add("https://firebasestorage.googleapis.com/v0/b/projectfinden.appspot.com/o/b1BatTinh.png?alt=media&token=b30a4583-a93b-4608-bb47-3564004f7d9c");
//        urls.add("https://firebasestorage.googleapis.com/v0/b/projectfinden.appspot.com/o/b1BatTinh.png?alt=media&token=b30a4583-a93b-4608-bb47-3564004f7d9c");
//        urls.add("https://firebasestorage.googleapis.com/v0/b/projectfinden.appspot.com/o/b1BatTinh.png?alt=media&token=b30a4583-a93b-4608-bb47-3564004f7d9c");
//        des.add("vvvvvvvvvvvvvvv");
//        des.add("vvvvvvvvvvvvvvvccccccccccc");
//        des.add("vvvvvvvvvvvvvvvcccccccccccxxxxxxxxx");
        buttonBatTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("/").child("FirstAidInstructions").child("fainting").child("studyAndGuide").child("case").child("none").child("step");
                ref.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                         Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();

//                         Toast.makeText(getActivity(), map+"\n"+"jjjjjj", Toast.LENGTH_LONG).show();
//                         for (String key : map.keySet()) {
//                             des.add(map.get(key).getDescription());
//                             urls.add(map.get(key).getImage());
//                         }
                         for (Map.Entry<String, Object> entry : map.entrySet()) {
                             Map<String, String> map1  = (Map<String, String>) entry.getValue();
                             for (Map.Entry<String, String> entry1: map1.entrySet()){
                                     String key1 = entry1.getKey();
                                     if(key1.equals("image")){
                                         urls.add(entry1.getValue());
                                     }
                                     else if(key1.equals("description")){
                                         des.add(entry1.getValue());
                                     }

                             }

                         }
                         FragmentTransaction fr= getFragmentManager().beginTransaction();
                         fr.replace(R.id.frameLayoutMenu,new FragmentStudyBattinh(des,urls));
                         fr.commit();


                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 });
//                FragmentTransaction fr= getFragmentManager().beginTransaction();
//                         fr.replace(R.id.frameLayoutMenu,new FragmentStudyBattinh(des,urls));
//                         fr.commit();
            }
        });
        return view;
    }

}
