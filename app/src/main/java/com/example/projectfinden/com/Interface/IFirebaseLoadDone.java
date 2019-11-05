package com.example.projectfinden.com.Interface;

import com.example.projectfinden.com.model.Step;


import java.util.List;

public interface IFirebaseLoadDone {

    //an interface to load movie from the firebase Database
    void onFirebaseLoadSuccess(List<Step> movieList);
    void onFirebaseLoadFailed(String message);
}
