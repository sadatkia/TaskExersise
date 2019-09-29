package com.example.task.Controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.task.R;

public class MyListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_containor_myTask);
        if (fragment == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_containor_List, new MyListFragment())
                    .commit();
            // MyListActivity.newInstance("YOR_TASK");

        }
    }
}
