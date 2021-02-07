package com.company.zad3.strategies;

public class DataReaderFileNotFoundExceptionStrategy implements IDataReaderExceptionStrategy {

    public String handle(Exception ex) {
        return "Cacher not refreshed data! File not found...";
    }

}