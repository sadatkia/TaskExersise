package com.example.task.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;
import java.util.UUID;

public class MyTask {
    private String name;
    private State state;
    private static UUID mID;

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    public UUID getUuID() {
        return mID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public MyTask() {
        mID.randomUUID();
    }

    public static UUID getId() {
        return mID;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyTask)) return false;
        MyTask myTask = (MyTask) o;
        return Objects.equals(getId(), myTask.getId());
    }
}
