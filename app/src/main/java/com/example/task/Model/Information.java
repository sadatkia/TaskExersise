package com.example.task.Model;

import java.util.UUID;

public class Information {
    private  String name;
    private State state;
    private UUID mID;

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

    public Information() {
       mID.randomUUID();
    }
}
