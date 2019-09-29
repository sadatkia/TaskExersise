package com.example.task.Controler;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.task.Model.MyTask;
import com.example.task.Model.State;
import com.example.task.R;


/**
 * A simple {@link Fragment} subclass.
 */


public class MyTask_Fragment extends Fragment {
    public static final String YOUR_TASK = "your_task";
    public static final String YOUR_NUM = "your_num";
    ///////////////////////////////////////////
    private MyTask mMyTask;
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
       /* mMyTask = new MyTask();
        mMyTask.setName(" Wash dishes ");
        mMyTask.setState(State.Todo)*/;
//getActivity().getIntent().getSerializableExtra(My_ID)
MyTask myNum=new MyTask();
myNum.setName(" Cleaning");
myNum.setState(State.Doing);
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
               int number = Integer.parseInt(mEditText_Num.getText().toString());
               intent.putExtra(YOUR_TASK  ,  mEditText_Task.getText().toString());
               intent.putExtra(YOUR_NUM , number);
               Editable str=mEditText_Task.getText();
               Editable i=mEditText_Num.getText();

               startActivity(intent);

              // getActivity().generatgetInstance();

            }
        });
       /////////////////////////////////////////////////////
        return view;
    }


}
