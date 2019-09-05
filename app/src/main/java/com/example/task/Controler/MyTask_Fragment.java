package com.example.task.Controler;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.task.MyListActivity;
import com.example.task.Model.Information;
import com.example.task.R;


/**
 * A simple {@link Fragment} subclass.
 */


public class MyTask_Fragment extends Fragment {
    public static final String YOUR_TASK = "your_task";
    public static final String YOUR_NUM = "your_num";
    ///////////////////////////////////////////
    private Information mInformation;
    private EditText mEditText_Task;
    private EditText mEditText_Num;
    private Button mButton_Show;
    //////////////////////////////////////
    public MyTask_Fragment() {
        // Required empty public constructor
    }
/////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* mInformation = new Information();
        mInformation.setName(" Wash dishes ");
        mInformation.setState(State.Todo)*/;
    }
///////////////////////////////////////////////////////////

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_task_, container, false);
////////////////////////after Infalator we cand find

        mEditText_Task =  view.findViewById(R.id.editText_Task);
        mEditText_Num = view.findViewById(R.id.editText_Num);
        mButton_Show = view. findViewById(R.id.button_show);
        mButton_Show.setEnabled(true);

       mButton_Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MyListActivity.class);
                intent.putExtra(YOUR_TASK,mEditText_Task.getText().toString());
                startActivity(intent);


          /*      Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                intent.putExtra("user", mEditTextUserName.getText().toString());

                Set in first activity fragment:

                Bundle bundle = new Bundle();
                bundle.putString("your_string_key", "your_value");

                startActivity(new Intent(getActivity() your_second_activity.class).putExtra("bundle_key", bundle));*/
            }
        });
       /////////////////////////////////////////////////////
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(YOUR_TASK, String.valueOf(mEditText_Task));
       // outState.putInt(YOUR_NUM,mEditText_Num);
    }
}
