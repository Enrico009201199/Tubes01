package com.example.tubes01;

import android.content.Context;
import android.content.SharedPreferences;

public class Penyimpan {
    protected SharedPreferences sharedPref;
    protected final static String NAMA_SHARED_PREF="sp";
    protected final static String KEY_NUMBERS = "NUMBERS";
    protected final static String KEY_RESULT = "RESULT";

    public Penyimpan(Context context) {
        this.sharedPref = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveNumber(String numbers) {
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_NUMBERS, numbers);
        editor.commit();
    }

    public void saveResult(int i) {
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putInt(KEY_RESULT, i);
        editor.commit();
    }

    public String getNumbers() {
        return sharedPref.getString(KEY_NUMBERS, "");
    }

    public int getResult() {
        return sharedPref.getInt(KEY_RESULT, 0);
    }
}
