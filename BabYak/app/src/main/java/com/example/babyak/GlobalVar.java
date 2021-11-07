package com.example.babyak;

import android.app.Application;

public class GlobalVar extends Application {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
