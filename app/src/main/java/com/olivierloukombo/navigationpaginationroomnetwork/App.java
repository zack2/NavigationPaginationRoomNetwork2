package com.olivierloukombo.navigationpaginationroomnetwork;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.facebook.stetho.Stetho;

public class App extends Application {
    private static final String TAG = App.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        Stetho.initializeWithDefaults(this);
    }


}
