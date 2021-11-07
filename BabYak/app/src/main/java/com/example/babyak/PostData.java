package com.example.babyak;

public class PostData {


    private String titlepost;
    private String textpost;
    private String uploaderpost;
    private String spotNamepost;
    private String headCountpost;

    public PostData(){}

    public PostData(String titlepost, String textpost, String uploaderpost, String spotNamepost, String headCountpost) {
        this.textpost = textpost;
        this.uploaderpost = uploaderpost;
        this.spotNamepost = spotNamepost;
        this.headCountpost = headCountpost;
    }

    public String getTitlepost() {
        return titlepost;
    }

    public void setTitlepost(String titlepost) {
        this.titlepost = titlepost;
    }

    public String getTextpost() {
        return textpost;
    }

    public void setTextpost(String textpost) {
        this.textpost = textpost;
    }

    public String getUploaderpost() {
        return uploaderpost;
    }

    public void setUploaderpost(String uploaderpost) {
        this.uploaderpost = uploaderpost;
    }

    public String getSpotNamepost() {
        return spotNamepost;
    }

    public void setSpotNamepost(String spotNamepost) {
        this.spotNamepost = spotNamepost;
    }

    public String getHeadCountpost() {
        return headCountpost;
    }

    public void setHeadCountpost(String headCountpost) {
        this.headCountpost = headCountpost;
    }

}
