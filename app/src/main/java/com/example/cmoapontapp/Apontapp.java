package com.example.cmoapontapp;

import android.app.Application;

public class Apontapp extends Application {

    private FirebaseRepository x;

    public static Apontapp INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        x = new FirebaseRepository();
    }

    public FirebaseRepository getX() {
        return x;
    }
}
