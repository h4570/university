package com.example.tipper;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BmiXAxisFormatter extends ValueFormatter {

    private SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
    private List<Date> dates;

    public BmiXAxisFormatter(String[] dateStrings) {
        this.dates = new ArrayList<>();
        for (String dateString : dateStrings) {
            try {
                Date date = inputDateFormat.parse(dateString);
                dates.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        int index = Math.round(value);
        if (index < 0 || index >= dates.size()) {
            return "";
        }
        return sdf.format(dates.get(index));
    }
}