package com.rohit.databasepractice;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    private final Context context;

    public MySharedPreference(Context context){
        this.context = context;
    }

    private SharedPreferences getPreference(){
        return ((Activity)context).getPreferences(Context.MODE_PRIVATE);
    }

    private SharedPreferences getPreference(String sharedpreferencename){
        return context.getApplicationContext().getSharedPreferences(sharedpreferencename,Context.MODE_PRIVATE);
    }

    void saveStringToDefault(String key,String value){
        SharedPreferences preferences = getPreference();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    String getStringFromDefault( String key){
        SharedPreferences preferences = getPreference();
        return preferences.getString(key,null);
    }

    void saveStringToCustomPreference(String sharedpreferencename, String key, String value){
        SharedPreferences preferences = getPreference(sharedpreferencename);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    String getStringFromCustomPreference(String sharedpreferencename, String key){
        SharedPreferences preferences = getPreference(sharedpreferencename);
        return preferences.getString(key,null);
    }



}
