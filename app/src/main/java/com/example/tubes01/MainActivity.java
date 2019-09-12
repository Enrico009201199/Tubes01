package com.example.tubes01;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements FragmentListener{

    protected MainFragment mainFragment;
    protected AddFragment addFragment;
    protected FragmentManager fragmentManager;
    protected Penyimpan penyimpan;
    protected Toolbar toolbar;
    protected DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mainFragment = MainFragment.newInstance();
        this.addFragment = AddFragment.newInstance();
        this.fragmentManager = this.getSupportFragmentManager();
        this.penyimpan = new Penyimpan(this);
        this.toolbar = this.findViewById(R.id.toolbar);
        this.drawer = this.findViewById(R.id.drawer_layout);
        this.setSupportActionBar(this.toolbar);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this, this.drawer, this.toolbar, R.string.openDrawer, R.string.closeDrawer);
        this.drawer.addDrawerListener(abdt);
        abdt.syncState();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        ft.add(R.id.fragment_container, this.mainFragment);
        ft.add(R.id.fragment_container, this.addFragment)
                .addToBackStack(null)
                .commit();
        ft.show(this.mainFragment);
        ft.hide(this.addFragment);
    }

    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if (page == 1) {
            if (this.mainFragment.isAdded()) {
                ft.show(this.mainFragment);
            }
            else{
                ft.add(R.id.fragment_container, this.mainFragment);
            }
            if (this.addFragment.isAdded()) {
                ft.hide(this.addFragment);
            }
        } else if (page == 2) {
            if (this.addFragment.isAdded()) {
                ft.show(this.addFragment);
            }
            else{
                ft.add(R.id.fragment_container, this.addFragment)
                        .addToBackStack(null);
            }
            if (this.mainFragment.isAdded()) {
                ft.hide(this.mainFragment);
            }
        }
        ft.commit();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.mainFragment.adapter.clearData();
        String[] split = this.penyimpan.getNumbers().split(",");
        for(int i = 0; i < split.length; i++) {
            this.mainFragment.adapter.addLine(split[i]);
        }
    }
}
