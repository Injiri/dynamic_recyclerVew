package com.example.genericc;

public class Topic {

    private String topicName;
    private String topicDesc;
    private boolean isTopicFavourite;

    private  Topic(){

    }

    public Topic(String topicName, String topicDesc, boolean isTopicFavourite) {
        this.topicName = topicName;
        this.topicDesc = topicDesc;
        this.isTopicFavourite = isTopicFavourite;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public boolean isTopicFavourite() {
        return isTopicFavourite;
    }

    public void setTopicFavourite(boolean topicFavourite) {
        isTopicFavourite = topicFavourite;
    }
}