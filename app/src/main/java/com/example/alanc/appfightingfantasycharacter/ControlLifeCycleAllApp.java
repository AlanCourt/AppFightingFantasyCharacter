package com.example.alanc.appfightingfantasycharacter;

import android.app.Application;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Sheisa on 01/07/2017.
 */

public class ControlLifeCycleAllApp extends Application {

    public static DatabaseReference myRef;

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        myRef = database.getReference();
    }

}