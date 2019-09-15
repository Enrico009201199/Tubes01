package com.example.tubes01;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LeftFragment extends Fragment implements View.OnClickListener
{
    protected Button btn_save, btn_result, btn_clear;
    protected MainActivity act;
    protected FragmentListener listener;

    public LeftFragment() {}

    public static LeftFragment newInstance() {
        LeftFragment fragment = new LeftFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        this.btn_clear = view.findViewById(R.id.left_btn_clear);
        this.btn_result = view.findViewById(R.id.left_btn_result);
        this.btn_save = view.findViewById(R.id.left_btn_save);
        this.btn_save.setOnClickListener(this);
        this.btn_result.setOnClickListener(this);
        this.btn_clear.setOnClickListener(this);
        this.act = (MainActivity)getActivity();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        }else{
            throw new ClassCastException(context.toString()+"must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn_clear.getId()) {
            this.act.mainFragment.adapter.clearData();
            this.act.addFragment.model.result = 0;
            this.act.addFragment.model.number = 0;
            this.act.addFragment.model.operator = '@';
            this.act.penyimpan.sharedPref.edit().clear();
            this.act.penyimpan.saveNumber(this.act.mainFragment.adapter.getItemList());
        }
        else if(view.getId() == this.btn_result.getId()) {
            this.act.addFragment.model.result = 0;
            this.act.addFragment.model.number = 0;
            this.act.addFragment. model.operator = '@';
            for(int i = 0; i < this.act.mainFragment.adapter.getCount(); i++) {
                String[] split = this.act.mainFragment.adapter.getItem(i).toString().split(" ");
                this.act.addFragment.model.operator = split[0].charAt(0);
                this.act.addFragment.model.number = Integer.parseInt(split[1]);
                this.act.addFragment.model.calculate();
            }
            Bundle data = new Bundle();
            data.putString("dialog", this.act.addFragment.model.result+"");
            ResultDialogFragment rdf = ResultDialogFragment.newInstance().newInstance();
            rdf.setArguments(data);
            FragmentTransaction ft = this.act.fragmentManager.beginTransaction();
            rdf.show(ft, "dialog");
        }
        else if(view.getId() == this.btn_save.getId()) {
            this.act.penyimpan.saveNumber(this.act.mainFragment.adapter.getItemList());
        }
        this.act.drawer.closeDrawers();
    }
}
