package com.example.task.Controler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.task.MyListActivity;
import com.example.task.R;

public class MyTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager=getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_containor_myTask);
        if (fragment == null){
fragmentManager
        .beginTransaction()
        .add(R.id.fragment_containor_myTask , new MyTask_Fragment())
        .commit();
//        Bundle bundle = new Bundle();
//        bundle.putString("your_string_key", "your_value");}

      //  startActivity(new Intent(getActivity() MyListActivity.class).putExtra("bundle_key", bundle));

    }}
}
