package com.example.task;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment {
public String intentString;

    public MyListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //intentString = getActivity().getIntent().getStringExtra("YOUR_TASK");
    }

    private EditText mEditTexte;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_list, container, false);
/////////////////////////////////////////////////////////////////////
     mEditTexte=view.findViewById(R.id.editText_for_example);
/////////////////////////////////////////////////////////////////////
        String temp =getActivity().getIntent().getStringExtra("your_task");
        mEditTexte.setText( temp );
        return view;
    }

}
