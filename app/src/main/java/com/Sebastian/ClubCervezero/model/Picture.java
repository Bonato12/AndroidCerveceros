package com.Sebastian.ClubCervezero.model;

public class Picture {

    private String picture, userName, time, likesNumber, promocion;

    public Picture(String picture, String userName, String time, String likesNumber, String promocion) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.likesNumber = likesNumber;
        this.promocion = promocion;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLikesNumber() {
        return likesNumber;
    }

    public void setLikesNumber(String likesNumber) {
        this.likesNumber = likesNumber;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }
}
