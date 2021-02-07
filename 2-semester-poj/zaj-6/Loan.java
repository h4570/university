/* Author: Sandro Sobczyński */

package com.company;

import java.util.Locale;

public abstract class Loan implements LoanConstants {

    private int loanNumber;
    private String customerLastName;
    private double loanAmount;
    protected double interestRate;
    private int term;

    public double getTotalAmount() {
        return loanAmount + (loanAmount * (interestRate / 100) * term);
    }

    public Loan(int loanNumber, String customerLastName, double loanAmount, int term)
            throws WrongTermException, WrongLoanAmountException {
        this.loanNumber = loanNumber;
        this.customerLastName = customerLastName;
        this.loanAmount = loanAmount;
        if (term == SHORT_TERM || term == MEDIUM_TERM || term == LONG_TERM)
            this.term = term;
        else
            throw new WrongTermException("Term should have value from one of terms in LoanConstants interface");
        if (loanAmount > 0 && loanAmount < MAX_LOAN_AMOUNT)
            this.term = term;
        else
            throw new WrongLoanAmountException(
                    "Loan amount should be greater than zero, and should not exceed the limit defined in "
                            + "LoanConstants interface");
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "Loan[loanNumber=%d, customerLastName=%s, loanAmount=%.2f, interestRate=%.2f, term=%d]", loanNumber,
                customerLastName, loanAmount, interestRate, term);
    }

}
