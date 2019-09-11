package com.example.tubes01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

public class AddFragment extends Fragment implements View.OnClickListener{
    protected Spinner spinner_operator;
    protected EditText et_operand;
    protected Button btn_submit;
    protected FragmentListener listener;

    public AddFragment () {}

    public static AddFragment newInstance() {
        AddFragment fragment = new AddFragment();
        return fragment;
    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_page, container, false);
        this.spinner_operator = view.findViewById(R.id.sp_operator);
        this.et_operand = view.findViewById(R.id.et_operand);
        this.btn_submit = view.findViewById(R.id.btn_submit);
        this.btn_submit.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
