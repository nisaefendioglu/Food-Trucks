package com.nisaefendioglu.food.model;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;

public class Meals {

    @SerializedName("meals")
    private List<Items> itemsList;

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public static class Items {

        @SerializedName("strMeal")
        private String strMeal;

        @SerializedName("strMealThumb")
        private String strMealThumb;

        @SerializedName("strYoutube")
        private String strYoutube;


        @SerializedName("strInstructions")
        private String strInstructions;

        public String getStrInstructions() {
            return strInstructions;
        }

        public void setStrInstructions(String strInstructions) {
            this.strInstructions = strInstructions;
        }

        public String getStrMeal() {
            return strMeal;
        }

        public void setStrMeal(String strMeal) {
            this.strMeal = strMeal;
        }

        public String getStrMealThumb() {
            return strMealThumb;
        }

        public void setStrMealThumb(String strMealThumb) {
            this.strMealThumb = strMealThumb;
        }

        public String getStrYoutube() {
            return strYoutube;
        }

        public void setStrYoutube(String strYoutube) {
            this.strYoutube = strYoutube;
        }
    }


}
