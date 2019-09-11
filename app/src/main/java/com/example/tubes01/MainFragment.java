package com.example.tubes01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment implements View.OnClickListener {

    protected TextView tv_1, tv_2;
    protected Button btn_add, btn_res, btn_clear, btn_save;
    protected FragmentListener listener;
    protected ListView list;
    protected TestAdapter adapter;
    protected MainActivity act;

    public MainFragment() {}

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }


    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.act = (MainActivity) getActivity();
        this.tv_1 = view.findViewById(R.id.calculator);
        this.tv_2 = view.findViewById(R.id.tv_result);
        this.btn_add = view.findViewById(R.id.btn_add);
        this.btn_res = view.findViewById(R.id.btn_result);
        this.btn_clear = view.findViewById(R.id.btn_clear);
        this.btn_save = view.findViewById(R.id.btn_save);
        this.btn_add.setOnClickListener(this);
        this.btn_res.setOnClickListener(this);
        this.btn_save.setOnClickListener(this);
        this.btn_clear.setOnClickListener(this);

        this.list = view.findViewById(R.id.list_number);
        this.adapter = new TestAdapter(this.act);
        this.list.setAdapter(this.adapter);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == this.btn_add.getId()) {
            this.act.changePage(2);
        }
        else if(view.getId() == this.btn_clear.getId()) {
            this.adapter.clearData();
        }
        else if(view.getId() == this.btn_res.getId()) {

        }
        else if(view.getId() == this.btn_save.getId()) {

        }
    }


}
