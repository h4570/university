/* Author: Sandro Sobczyński */

package com.company;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setHour(int value) {
        this.hour = value;
    }

    public void setMinute(int value) {
        this.minute = value;
    }

    public void setSecond(int value) {
        this.second = value;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String toString() {
        String fixedHour = '0' + Integer.toString(hour);
        fixedHour = fixedHour.substring(fixedHour.length() - 2, fixedHour.length());
        String fixedMinute = '0' + Integer.toString(minute);
        fixedMinute = fixedMinute.substring(fixedMinute.length() - 2, fixedMinute.length());
        String fixedSecond = '0' + Integer.toString(second);
        fixedSecond = fixedSecond.substring(fixedSecond.length() - 2, fixedSecond.length());
        return String.format("%s:%s:%s", fixedHour, fixedMinute, fixedSecond);
    }

    public Time nextSecond() {
        if (second == 59) {
            second = 0;
            if (minute == 59) {
                minute = 0;
                if (hour == 23)
                    hour = 0;
                else
                    hour += 1;
            } else {
                this.minute += 1;
            }
        } else
            this.second += 1;
        return this;
    }

    public Time previousSecond() {
        if (second == 0) {
            second = 59;
            if (minute == 0) {
                minute = 59;
                if (hour == 0)
                    hour = 23;
                else
                    hour -= 1;
            } else {
                this.minute -= 1;
            }
        } else
            this.second -= 1;
        return this;
    }

}