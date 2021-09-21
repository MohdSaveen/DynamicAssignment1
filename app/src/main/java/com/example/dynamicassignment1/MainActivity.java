package com.example.dynamicassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        replaceFragment();
    }

    private void replaceFragment() {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        MainFragment mainFragment=new MainFragment();
        transaction.replace(R.id.flContainer,mainFragment).commit();
    }
}