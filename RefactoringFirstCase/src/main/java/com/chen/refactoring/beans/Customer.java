package com.chen.refactoring.beans;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Decription:
 * @Author TY-wqchen
 * @Date 2021/3/12 14:44
 */
public class Customer {
    private String _name;
    private Vector _rentals = new Vector();
    private int frequentRenterPoints = 0;
    private double totalAmount = 0;

    public Customer(String name) {
        this._name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName(){
        return _name;
    }

    public String statement(){
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            //determine amount for each line
            double thisAmount = getThisAmountTemp(each);
            frequentRenterPoints = calculateFrequentRenterPoints(frequentRenterPoints, each);

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";

        return result;
    }

    private int calculateFrequentRenterPoints(int frequentRenterPoints, Rental each) {
        //add frequent renter points
        frequentRenterPoints ++;
        //add bonus for a two day new release rental
        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    private double getThisAmountTemp(Rental each) {
        double thisAmount = 0;
        return getThisAmount(each);
    }
    private double getThisAmount(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

}
