package com.example.tubes01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class ResultDialogFragment extends DialogFragment {

    protected TextView tv_dialog;

    public ResultDialogFragment() {}

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_dialog, container);
        this.tv_dialog = view.findViewById(R.id.tv_dialog);
        String msg = getArguments().getString("dialog");
        this.tv_dialog.setText("The result is: " + msg);
        return view;
    }

    public static ResultDialogFragment newInstance() {
        ResultDialogFragment fragment = new ResultDialogFragment();
        return fragment;
    }

}
