package com.chen.refactoring.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @Decription:
 * @Author TY-wqchen
 * @Date 2021/3/12 15:48
 */
class CustomerTest {
    private static Object[][] getExpectedStrAndCustomer() {
        Customer maimai = new Customer("maimai");
        Movie movie = new Movie("Hai mian bao bao", Movie.CHILDRENS);
        Rental arg = new Rental(movie, 100);
        Movie movie1 = new Movie("Tai tang ni ke", Movie.NEW_RELEASE);
        Rental arg1 = new Rental(movie1, 100);
        maimai.addRental(arg);
        maimai.addRental(arg1);

        String expected = "Rental Record for maimai\n" +
                "\tHai mian bao bao\t147.0\n" +
                "\tTai tang ni ke\t300.0\n" +
                "Amount owed is 447.0\n" +
                "You earned 3 frequent renter points";

        return new Object[][]{
                {expected, maimai}
        };
    }

    @ParameterizedTest
    @MethodSource("getExpectedStrAndCustomer")
    void test_returnString_equal_the_expected_when_statement_given_default_input(String expected, Customer customer) {
        Assertions.assertEquals(expected, customer.statement());
    }
}