package com.ishmam.DhrubokPracticeProject1.Helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateGenerator {
    public static String generateDate(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
    }
}
