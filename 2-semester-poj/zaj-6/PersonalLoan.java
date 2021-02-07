/* Author: Sandro Sobczyński */

package com.company;

public class PersonalLoan extends Loan {

    public PersonalLoan(int loanNumber, String customerLastName, double loanAmount, int term, double primeInterestRate)
            throws WrongTermException, WrongLoanAmountException {
        super(loanNumber, customerLastName, loanAmount, term);
        super.interestRate = primeInterestRate * 1.02;
    }

}
