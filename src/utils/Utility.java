package utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utility {

    public static Scanner sc = new Scanner(System.in);
    public static void println(String message){
        System.out.println("*************************************\n");
        System.out.println(message);
        System.out.println("*************************************\n");
    }

    public static String giveTime(){
        LocalTime currentHour = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatedHour = currentHour.format(formatter);

        return formatedHour;
    }
}

