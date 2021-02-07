package com.company.zad3.strategies;

public class DataReaderFileReadingExceptionStrategy implements IDataReaderExceptionStrategy {

    public String handle(Exception ex) {
        return "Cacher not refreshed data! File is corrupted?";
    }

}