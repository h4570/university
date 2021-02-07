package com.company.zad3.strategies;

public class DataReaderLockedFileExceptionStrategy implements IDataReaderExceptionStrategy {

    public String handle(Exception ex) {
        return "Cacher not refreshed data! File is locked...";
    }

}