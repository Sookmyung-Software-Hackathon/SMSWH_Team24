package com.example.babyak;

public class ChatData {
    private int imageID;
    private String id;
    private String content;

    public ChatData(){}

    public ChatData(int imageID, String id, String content) {
        this.imageID = imageID;
        this.id = id;
        this.content = content;
    }

    public int getImageID() {
        return imageID;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
