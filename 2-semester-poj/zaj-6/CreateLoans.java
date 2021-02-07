/* Author: Sandro Sobczyński */

package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CreateLoans {

    public static void main(String[] args) {
        ArrayList<Loan> loans = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("--=Welcome to the loan system=--");
            double primeInterestRate = getPrimeInterestRate(scanner);
            System.out.println("-> Let start with creating five loans");
            addFiveLoans(primeInterestRate, scanner, loans);
            scanner.close();
        } catch (InputMismatchException ex) {
            System.out.println("Hmm.. please do not hurt our system. Now you must start again!");
        }
        printLoans(loans);
    }

    private static double getPrimeInterestRate(Scanner scanner) {
        System.out.print("Please enter prime interest rate: ");
        return scanner.nextDouble();
    }

    private static void addFiveLoans(double primeInterestRate, Scanner scanner, ArrayList<Loan> loans) {
        int amountOfLoans = 5;
        for (int i = 0; i < amountOfLoans; i++) {
            System.out.println();
            System.out.println(String.format("-> Creating %d loan", i + 1));

            System.out.print("Please enter your last name: ");
            String customerLastName = scanner.next();

            System.out.println(String.format(Locale.US, "Please enter loan amount. You can't exceed $%d",
                    LoanConstants.MAX_LOAN_AMOUNT));
            System.out.print("Loan amount: ");
            double loanAmount = scanner.nextDouble();

            System.out.print(String.format(Locale.US,
                    "Please enter amount of years to final term. It can be %d, %d or %d years: ",
                    LoanConstants.SHORT_TERM, LoanConstants.MEDIUM_TERM, LoanConstants.LONG_TERM));
            int term = scanner.nextInt();

            System.out.print("It will be a business loan? (y/N): ");
            String loanTypeInput = "";
            scanner.nextLine();
            loanTypeInput = scanner.nextLine();

            Loan newLoan = null;
            try {
                if (loanTypeInput.toLowerCase().equals("y"))
                    newLoan = new BusinessLoan(i, customerLastName, loanAmount, term, primeInterestRate);
                else
                    newLoan = new PersonalLoan(i, customerLastName, loanAmount, term, primeInterestRate);
                loans.add(newLoan);
            } catch (WrongTermException ex) {
                System.out.println("Entered term is wrong. Please try again.");
                i -= 1;
            } catch (WrongLoanAmountException ex) {
                System.out.println("Entered loan amount is wrong. Please try again.");
                i -= 1;
            }
        }
    }

    private static void printLoans(ArrayList<Loan> loans) {
        for (Loan loan : loans) {
            System.out.println("Loans: ");
            System.out.println(loan);
        }
    }

}
