package com.company.zad3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;

import com.company.zad3.models.Data;

public class DataReader {

    private String path;

    public DataReader() {
        this.path = "com/company/zad3/data.csv";
    }

    public ArrayList<Data> getCurrentData() throws FileNotFoundException, OverlappingFileLockException, Exception {
        ArrayList<Data> result = new ArrayList<Data>();
        BufferedReader lineReader = new BufferedReader(new FileReader(this.path));
        String lineText = null;
        lineReader.readLine();
        while ((lineText = lineReader.readLine()) != null) {
            String[] data = lineText.split(";");
            Data obj = new Data();
            obj.ID = Integer.parseInt(data[0].trim());
            obj.IntKey = Integer.parseInt(data[1].trim());
            obj.StringKey = data[2].trim();
            obj.Value = data[3].trim();
            obj.EnumerationName = data[4].trim();
            result.add(obj);
        }
        lineReader.close();
        return result;
    }

}