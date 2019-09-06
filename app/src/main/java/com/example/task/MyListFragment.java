package com.example.task;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.Model.MyTask;
import com.example.task.repository.TaskRepository;

import org.w3c.dom.Text;

import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment {
    public String intentString;

    private RecyclerView mRecyclerView;
    private TaskAdaptor mAdapter;


    public MyListFragment() {
        // Required empty public constructor
    }

    //////////////////////////////////////////////On Creat Section/////////////////////////////////////////////////
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //intentString = getActivity().getIntent().getStringExtra("YOUR_TASK");
    }

    /////////////////////////////////////////Initialise Section
    public EditText mEditTexte;


    ///////////////////////////////////////On CreatView Section/////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
/////////////////////////////////////////////////////////////////////
        mEditTexte = view.findViewById(R.id.editText_for_example);
////////////////////////////////////////////////intent section/////////////////////
        String temp = getActivity().getIntent().getStringExtra("your_task");
        mEditTexte.setText(temp);
        ////////////////////////////////////////////////////find recycelerwiew
        mRecyclerView = view.findViewById(R.id.id_Fragment_RecycelerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
/////////////////////////////////////////////////Set Adaptor Recycleview////////
        TaskRepository repository = new TaskRepository();
        List<MyTask> crimes = repository.getCrimes();
        mAdapter = new TaskAdaptor(crimes);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


    /////////////////////////////////////////////////Class for view holder//////////

    private class TaskViewHolder extends RecyclerView.ViewHolder {
        private TextView mTask;
        private TextView mState;
        public MyTask mMyTask;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mTask = itemView.findViewById(R.id.txtview_list_item_task);
            mState = itemView.findViewById(R.id.txtview_list_item_stat);

        }

        public void bind(MyTask myTask) {
            mTask = myTask;
            mTask.setText(myTask.getName());
            mState.setText(myTask.getState());

        }
    }


    ///////////////////////////////////////////////////////
    private class TaskAdaptor extends RecyclerView.Adapter {

        /////////////////////////////////////
        private List<MyTask> mTasks;

        ///////////////////////
        public TaskAdaptor(List<MyTask> Tasks) {
            mTasks = Tasks;

        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(getActivity());    /////////////چند تا توی اینترنت بود .اینو انتخاب کررش .how inflator in layout
            View view = inflater.inflate(R.layout.list_itemview_task, parent, false);///سه تا ورودی داره رو انتخاب کنید بقیه کرش می کند حواستان باشد
            return new TaskViewHolder(view);////// ویو هلدر خودتان را استفاده کنید
        }

        ////////////////////bind section
        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       /* holder.mTask.setText(mTasks.get(position).getName());
            holder.mState.setText(mTasks.get(position).getState().toString());*/
            holder.bind(mTasks.get(position));
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}
