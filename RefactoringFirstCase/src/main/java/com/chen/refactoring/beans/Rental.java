package com.chen.refactoring.beans;

/**
 * @Decription:
 * @Author TY-wqchen
 * @Date 2021/3/12 14:40
 */
public class Rental {
    protected Movie movie;
    protected int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }
}
