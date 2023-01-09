package com.airlines.yourairlines.dto;

public class Plane extends LongIdDto {
    private String sideNumber;
    private String brand;
    private String model;
    private Coordinates planeCoordinates;
    private PlaneState planeState;

    public String getSideNumber() {
        return sideNumber;
    }

    public void setSideNumber(String sideNumber) {
        this.sideNumber = sideNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Coordinates getPlaneCoordinates() {
        return planeCoordinates;
    }

    public void setPlaneCoordinates(Coordinates planeCoordinates) {
        this.planeCoordinates = planeCoordinates;
    }

    public PlaneState getPlaneState() {
        return planeState;
    }

    public void setPlaneState(PlaneState planeState) {
        this.planeState = planeState;
    }
}
