package com.example.tubes01;

import android.content.Context;
import android.content.SharedPreferences;

public class Penyimpan {
    protected SharedPreferences sharedPref;
    protected final static String NAMA_SHARED_PREF="sp";
    protected final static String KEY_NUMBERS = "NUMBERS";

    public Penyimpan(Context context) {
        this.sharedPref = context.getSharedPreferences(NAMA_SHARED_PREF,0);
    }

    public void saveNumber(String numbers) {
        SharedPreferences.Editor editor = this.sharedPref.edit();
        editor.putString(KEY_NUMBERS, numbers);
        editor.commit();
    }

    public String getNumbers() {
        return sharedPref.getString(KEY_NUMBERS, "");
    }
}
