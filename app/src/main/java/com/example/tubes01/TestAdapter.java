package com.example.tubes01;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TestAdapter extends BaseAdapter {
    private Activity act;
    private List<String> list;

    public TestAdapter(Activity act) {
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
        String res = this.getItem(0).toString();
        for(int i = 1; i < this.getCount(); i++) {
            res += ","+this.getItem(i).toString();
        }
        return res;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = this.act.getLayoutInflater().inflate(R.layout.number_list_item, null);
        TextView tvNama = itemView.findViewById(R.id.tv_title);
        tvNama.setText(this.list.get(i));
        return itemView;
    }

    public void addLine(String item) {
        this.list.add(item);
        this.notifyDataSetChanged();
    }

    public void clearData() {
        this.list.clear();
        this.notifyDataSetChanged();
    }
}