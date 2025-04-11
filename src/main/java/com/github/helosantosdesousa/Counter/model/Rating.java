package com.github.helosantosdesousa.Counter.model;

import java.util.List;

public class Rating<T>{
    private T item;
    private double rating;
    private String comment;

    public Rating(T item, double rating, String comment) {
        this.item = item;
        this.rating = rating;
        this.comment = comment;
    }

    public double getAverage(List<Rating<T>> ratings){
        double sum=0;
        if(ratings.isEmpty()){
            throw new IllegalArgumentException("The list can not be empty");
        }
        for(Rating<T> r: ratings){
            sum += r.getRating();
        }
        return sum;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if(rating <0 || rating>5){
            throw new IllegalArgumentException("The ratings must be from 0 to 5");
        }
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
