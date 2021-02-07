/* Author: Sandro Sobczyński */

package com.company.zad3;

import java.io.FileNotFoundException;
import java.nio.channels.OverlappingFileLockException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.company.zad3.models.Data;
import com.company.zad3.strategies.DataReaderExceptionContext;
import com.company.zad3.strategies.DataReaderFileNotFoundExceptionStrategy;
import com.company.zad3.strategies.DataReaderFileReadingExceptionStrategy;
import com.company.zad3.strategies.DataReaderLockedFileExceptionStrategy;

public class Cacher {

    private static Cacher instance = null;

    private ArrayList<Data> data;
    private LocalDateTime refreshDate;
    private DataReader dataReader;
    private DataReaderExceptionContext exceptionContext;

    private Cacher() {
        dataReader = new DataReader();
        exceptionContext = new DataReaderExceptionContext();
    }

    public static Cacher getInstance() {
        if (instance == null)
            instance = new Cacher();
        return instance;
    }

    public ArrayList<Data> getData() {
        if (this.refreshDate != null) {
            long minutes = ChronoUnit.MINUTES.between(this.refreshDate, LocalDateTime.now());
            if (minutes > 5)
                refreshData();
        } else
            refreshData();
        return this.data;
    }

    private void refreshData() {
        try {
            this.data = dataReader.getCurrentData();
        } catch (FileNotFoundException ex) {
            exceptionContext.set(ex, new DataReaderFileNotFoundExceptionStrategy());
        } catch (OverlappingFileLockException ex) {
            exceptionContext.set(ex, new DataReaderLockedFileExceptionStrategy());
        } catch (Exception ex) {
            exceptionContext.set(ex, new DataReaderFileReadingExceptionStrategy());
        }
        if (exceptionContext.isStrategyActivated()) {
            exceptionContext.print();
        } else {
            this.refreshDate = LocalDateTime.now();
        }
    }

}