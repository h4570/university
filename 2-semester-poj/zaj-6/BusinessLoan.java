/* Author: Sandro Sobczyński */

package com.company;

public class BusinessLoan extends Loan {

    public BusinessLoan(int loanNumber, String customerLastName, double loanAmount, int term, double primeInterestRate)
            throws WrongTermException, WrongLoanAmountException {
        super(loanNumber, customerLastName, loanAmount, term);
        super.interestRate = primeInterestRate * 1.01;
    }

}
