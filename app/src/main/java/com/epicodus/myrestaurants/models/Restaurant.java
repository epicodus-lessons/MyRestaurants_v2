package com.epicodus.myrestaurants.models;

public class Restaurant {
    private String mName;
    private double mAverageCost;
    private int mRating;
    private String mWebsite;
    private String mImageUrl;
    private String mFoodType;

    public Restaurant(String name, double averageCost, int rating, String website, String imageUrl, String foodType) {
        this.mName = name;
        this.mAverageCost = averageCost;
        this.mRating = rating;
        this.mWebsite = website;
        this.mImageUrl = imageUrl;
        this.mFoodType = foodType;
    }

    public String getName() {
        return mName;
    }

    public double getAverageCost() {
        return mAverageCost;
    }

    public String getWebsite() {
        return  mWebsite;
    }

    public int getRating() {
        return mRating;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public String getFoodType(){
        return mFoodType;
    }

}
