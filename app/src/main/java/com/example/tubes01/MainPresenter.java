package com.example.tubes01;

import android.app.Activity;
import android.graphics.ColorSpace;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainPresenter {
    private ModelCalculator model;
    private TestAdapter adapter;

    public MainPresenter(Activity act) {
        this.model = new ModelCalculator();
        this.adapter = new TestAdapter(act);
    }

    public void calculate() {
        this.model.calculate();
    }

    public int getCount() {
        return this.adapter.getCount();
    }

    public void clearData() {
        this.adapter.clearData();
    }

    public void addLine(String string) {
        this.adapter.addLine(string);
    }

    public Object getItem(int i) {
        return this.adapter.getItem(i);
    }

    public long getItemID() {
        return 0;
    }

    public String getItemList() {
        return this.adapter.getItemList();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.adapter.getView(i, view, viewGroup);
    }

    public ModelCalculator getModel() {
        return this.model;
    }

    public TestAdapter getAdapter() {
        return this.adapter;
    }
}
