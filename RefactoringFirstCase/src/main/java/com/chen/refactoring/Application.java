package com.chen.refactoring;

import com.chen.refactoring.beans.Customer;
import com.chen.refactoring.beans.Movie;
import com.chen.refactoring.beans.Rental;

/**
 * @Decription:
 * @Author TY-wqchen
 * @Date 2021/3/12 14:48
 */
public class Application {
    public static void main(String[] args) {
        Customer maimai = new Customer("maimai");
        Movie movie = new Movie("Hai mian bao bao", Movie.CHILDRENS);
        Rental arg = new Rental(movie, 100);
        Movie movie1 = new Movie("Tai tang ni ke", Movie.NEW_RELEASE);
        Rental arg1 = new Rental(movie1, 100);
        maimai.addRental(arg);
        maimai.addRental(arg1);
        System.out.println(maimai.statement());
    }
}
