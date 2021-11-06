package com.example.babyak;

public class MainData {

    private int iv_profile;
    private String tv_title, tv_content,tv_date, tv_place, tv_people, tv_writer;

    public MainData( String tv_title, String tv_content, String tv_date, String tv_place, String tv_people, String tv_writer) {
        //this.iv_profile = iv_profile;
        this.tv_title = tv_title;
        this.tv_content = tv_content;
        this.tv_date = tv_date;
        this.tv_place = tv_place;
        this.tv_people = tv_people;
        this.tv_writer = tv_writer;
    }

    public int getIv_profile() {
        return iv_profile;
    }

    public void setIv_profile(int iv_profile) {
        this.iv_profile = iv_profile;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_content() {
        return tv_content;
    }

    public void setTv_content(String tv_content) {
        this.tv_content = tv_content;
    }

    public String getTv_date() {
        return tv_date;
    }

    public void setTv_date(String tv_date) {
        this.tv_date = tv_date;
    }

    public String getTv_place() {
        return tv_place;
    }

    public void setTv_place(String tv_place) {
        this.tv_place = tv_place;
    }

    public String getTv_people() {
        return tv_people;
    }

    public void setTv_people(String tv_people) {
        this.tv_people = tv_people;
    }

    public String getTv_writer() {
        return tv_writer;
    }

    public void setTv_writer(String tv_writer) {
        this.tv_writer = tv_writer;
    }
}






