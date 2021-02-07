package com.company.zad3.strategies;

public class DataReaderExceptionContext {

    private IDataReaderExceptionStrategy strategy;
    private Exception exception;

    public void set(Exception ex, IDataReaderExceptionStrategy strategy) {
        this.strategy = strategy;
        this.exception = ex;
    }

    public boolean isStrategyActivated() {
        return this.strategy != null;
    }

    public void print() {
        String text = strategy.handle(exception);
        System.out.println(text);
    }

}