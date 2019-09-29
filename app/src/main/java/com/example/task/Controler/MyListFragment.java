package com.example.task.Controler;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.task.Model.MyTask;
import com.example.task.R;
import com.example.task.repository.TaskRepository;

import java.util.List;

import static com.example.task.Controler.MyTask_Fragment.YOUR_NUM;
import static com.example.task.Controler.MyTask_Fragment.YOUR_TASK;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends Fragment {
    public String intentString;

    private RecyclerView mRecyclerView;
    private TaskAdaptor mAdapter;
private int Num;

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
    public EditText mEditTexte1;

    ///////////////////////////////////////On CreatView Section/////////////////////////////////////////////
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
/////////////////////////////////////////////////////////////////////
        mEditTexte = view.findViewById(R.id.editText_for_example);
        mEditTexte1 = view.findViewById(R.id.editText_for_example1);
////////////////////////////////////////////////intent section/////////////////////
    String Task = getActivity().getIntent().getStringExtra(YOUR_TASK);
     Num = getActivity().getIntent().getIntExtra((YOUR_NUM), 0);

    TaskRepository taskRepository = TaskRepository.getInstance();

    mEditTexte.setText((Task));
    mEditTexte1.setText(String.valueOf(Num));

        ////////////////////////////////////////////////////find recycelerwiew
        mRecyclerView = view.findViewById(R.id.id_Fragment_RecycelerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
/////////////////////////////////////////////////Set Adaptor Recycleview////////
        TaskRepository repository =  TaskRepository.getInstance();

        List<MyTask> myTasks = repository.MyNew(Num, Task);
        mAdapter = new TaskAdaptor(myTasks);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }


    /////////////////////////////////////////////////Class for view holder//////////
    //private MyTask  myTask;
    private class TaskViewHolder extends RecyclerView.ViewHolder {
        public static final String MY_ID = "my Id";
        private TextView mTask;
        private TextView mState;
        public MyTask mMyTask;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mTask = itemView.findViewById(R.id.txtview_list_item_task);
            mState = itemView.findViewById(R.id.txtview_list_item_stat);


//////////////


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(getActivity(), MyTask.class);
                    intent.putExtra(MY_ID,MyTask.getId());
                    startActivity(intent);
                }
            });


        }

        public void bind(MyTask myTask) {
         mMyTask = myTask;
            mTask.setText(mMyTask.getName());;
            mState.setText(mMyTask.getState().toString());

        }


    }


    ///////////////////////////////////////////////////////
    private class TaskAdaptor extends RecyclerView.Adapter<TaskViewHolder> {

        private static final int LAYOUT_ONE =1 ;
        private static final int LAYOUT_TWO =2 ;
        ////      /////////////////////
        private List<MyTask> mTasks;
        ////      /////////////////
        public TaskAdaptor(List<MyTask> Tasks) {
            mTasks = Tasks;

        }
////////////////////////////////////////////for colore////////
@Override
public int getItemViewType(int position)
{
    if(position%2==0)       // Even position
        return LAYOUT_ONE;
    else                   // Odd position
        return LAYOUT_TWO;


}

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(getActivity());
            /////////////چند تا توی اینترنت بود .اینو انتخاب کررش .how inflator in layout
/*

                View view = inflater.inflate(R.layout.list_itemview_task, parent, false);///سه تا ورودی داره رو انتخاب کنید بقیه کرش می کند حواستان باشد
             return new TaskViewHolder(view);////// ویو هلدر خودتان را استفاده کنید*/

            View view;
            switch (viewType) {
                case LAYOUT_ONE:
                    return new TaskViewHolder(inflater.inflate(R.layout.list_itemview_task, parent, false));
                default:

                    return new TaskViewHolder(inflater.inflate(R.layout.list_itemview_task2, parent, false));

            }
        }



        ////////////////////bind section
        @Override

        public void onBindViewHolder(@NonNull TaskViewHolder holder , int position) {
     // holder.mMyTask.setText(mTasks.get(position).getName());
          //  holder.mMyState.setText(mTasks.get(position).getState().toString());
         holder.bind(mTasks.get(position));
        }

        @Override
        public int getItemCount() {
            return mTasks.size();
        }
    }
}
