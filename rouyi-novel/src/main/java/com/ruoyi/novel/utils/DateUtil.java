package com.ruoyi.novel.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class DateUtil {
    public String SimpleDate(String dateTime) {
        dateTime = dateTime.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = format.parse(dateTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return  defaultFormat.format(time);

    }

    public String currentTime(){
        long currentTime = System.currentTimeMillis();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = new Date(currentTime);

       return formatter.format(date);

    }
}
