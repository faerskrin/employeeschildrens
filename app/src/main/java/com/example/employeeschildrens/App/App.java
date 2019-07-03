package com.example.employeeschildrens.App;

import android.app.Application;

import com.example.employeeschildrens.Data.DataManager;


public class App extends Application {
    public static DataManager dmManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dmManager = new DataManager();
    }
}
