package com.nisaefendioglu.food.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Meals {

    @SerializedName("meals")
    private ArrayList<Items> itemsArrayList;

    public ArrayList<Items> getItemsArrayList() {
        return itemsArrayList;
    }

    public void setItemsArrayList(ArrayList<Items> itemsArrayList) {
        this.itemsArrayList = itemsArrayList;
    }

}
