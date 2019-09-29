package com.example.task.repository;

import com.example.task.Model.MyTask;
import com.example.task.Model.State;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {
    private List<MyTask> mMyTasks;
/*    private static int num;
    private static String name;*/
    private static  TaskRepository instance ;
////////////////////////////////////////////////geter seter section
    public static TaskRepository getInstance() {
        if (instance==null)
            instance=new TaskRepository();
        return instance; }
////////////////////////////////////////////////



  private TaskRepository() {

    }

    public List<MyTask>     MyNew(int Num, String Task){
        mMyTasks = new ArrayList<>();
        for (int i = 0; i < Num; i++) {
            MyTask myTask = new MyTask();
            myTask.setName(Task+"#" + (i + 1));
            double R= Math.random();
            R= (int) (R*10);
            if (R< 3.5  ) {
                myTask.setState(State.Done);}
            else if  (3.5 <= R  && R<=7){
                myTask.setState(State.Todo);
            }
            else if(7 <= R  && R<10)
                myTask.setState(State.Doing);
            mMyTasks.add(myTask);   //////100 تا کرایم ساخت یکی در میان ترو فالس گذاشت
        }
        return mMyTasks;
    }

    //read
    public List<MyTask> getMyTasks() {
        return mMyTasks;
    }
    public void setMyTasks(List<MyTask>myTasks) {
        mMyTasks = myTasks;
    }
//////////////////////////////////////////////////////////


    //read
    public MyTask getInformation(UUID id) {
        for (MyTask MyTask : mMyTasks) {
            if (MyTask.getId().equals(id))
                return MyTask;
        }

        return null;
    }

    //insert
    public void insertMyTask(MyTask myTask) {
        mMyTasks.add(myTask);
    }

    //delete
    public void deleteTask(MyTask myTask) {
        if (myTask != null)
            mMyTasks.remove(myTask);
    }

    //delete
    public void deleteInformation(UUID id) {
        deleteTask(getInformation(id));
    }

    ///////معادل همین ذیریه هست .......ولی اومدیم از تابع زیریه استفاده کردیم
/*    Crime crime=getCrime(id);
    if(crime!=null)
    mCrimes.remove(crime)*/



}
