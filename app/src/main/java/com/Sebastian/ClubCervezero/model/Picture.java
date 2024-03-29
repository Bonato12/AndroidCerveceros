package com.Sebastian.ClubCervezero.model;

public class Picture {

    private String picture, userName, time,descripcion, likesNumber, promocion;
    private double longitud, latitud;

    public Picture(String picture, String userName, String time, String likesNumber, String promocion,String descripcion, double latitud, double longitud) {
        this.picture = picture;
        this.userName = userName;
        this.time = time;
        this.likesNumber = likesNumber;
        this.promocion = promocion;
        this.descripcion = descripcion;
        this.latitud = latitud;
        this.longitud = longitud;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
}
