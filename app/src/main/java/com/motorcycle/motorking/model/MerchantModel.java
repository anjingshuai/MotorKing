package com.motorcycle.motorking.model;

public class MerchantModel {
    public String name;
    public String address;
    public String distance;
    public String serviceCategory;
    public double rankNumber;

    public MerchantModel(String name, String address, String distance, String serviceCategory, double rankNumber) {
        this.name = name;
        this.address = address;
        this.distance = distance;
        this.serviceCategory = serviceCategory;
        this.rankNumber = rankNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public double getRankNumber() {
        return rankNumber;
    }

    public void setRankNumber(double rankNumber) {
        this.rankNumber = rankNumber;
    }
}
