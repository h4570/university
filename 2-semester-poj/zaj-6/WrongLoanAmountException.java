/* Author: Sandro Sobczyński */

package com.company;

public class WrongLoanAmountException extends Exception {

    private static final long serialVersionUID = -1072605492351566482L;

    public WrongLoanAmountException(final String message) {
        super(message);
    }
}
