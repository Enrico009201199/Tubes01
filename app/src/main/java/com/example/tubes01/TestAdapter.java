package com.example.tubes01;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends BaseAdapter implements View.OnClickListener {
    private MainActivity act;
    private List<String> list;
    private TextView cek;
    private ImageButton btn;
    private int idx;

    public TestAdapter(MainActivity act) {
        this.act = act;
        this.list = new ArrayList<String>();

    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int i) {
        return this.list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public String getItemList() {
        if(this.getCount() != 0) {
            String res = this.getItem(0).toString();
            for (int i = 1; i < this.getCount(); i++) {
                res += "," + this.getItem(i).toString();
            }
            return res;
        }
        else {
            return null;
        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = this.act.getLayoutInflater().inflate(R.layout.number_list_item, null);
        this.idx = i;
        this.cek = itemView.findViewById(R.id.tv_title);
        this.btn = itemView.findViewById(R.id.delete);
        this.btn.setOnClickListener(this);
        this.cek.setText(this.list.get(i));
        return itemView;
    }

    public void addLine(String item) {
        this.list.add(item);
        this.notifyDataSetChanged();
    }

    public void deleteLine(int i) {
        this.list.remove(i);
        this.notifyDataSetChanged();
    }

    public void clearData() {
        this.list.clear();
        this.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == this.btn.getId()) {
            this.deleteLine(this.list.indexOf(this.cek.getText().toString()));
        }
    }
}