package com.pondit.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Condition has 3 patterns
 *  -> if .. else if .. else
 *  -> switch .. case (with new pattern introduced in java 17)
 *  -> Ternary operator
*/
public class Conditions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (System.in));
        // Check the day
        while (true) {
            System.out.println ("What day is it?");
            String day = bufferedReader.readLine ();
            // If in saturday or sunday, we don't need to take input for office
            boolean hasOffice = false;
            if (!("Saturday".equalsIgnoreCase (day) || "Sunday".equalsIgnoreCase (day))) {
                System.out.println ("Do you have office today?");
                hasOffice = bufferedReader.readLine ().equalsIgnoreCase ("Yes"); // some_boolean ? true : false
            }
            // Check if the user has any emergency
            System.out.println ("Do you have any emergency?");
            boolean hasEmergency = bufferedReader.readLine ().equalsIgnoreCase ("Yes");
            DailyRoutine routine = new DailyRoutine ();

            routine.dailyRoutine (day, hasOffice, hasEmergency);
        }
    }
}


class DailyRoutine {
    public void dailyRoutine(String day, boolean hasOffice, boolean hasEmergency) {
        // Java 17 switch case
        if (hasEmergency) {
            System.out.println ("Has some emergency. Postpone all schedules");
        } else {
            switch (day) {
                case "Saturday", "Sunday" -> {
                    System.out.println ("Weekend");
                    System.out.println ("long sleep");
                }
                default -> {
                    if (hasOffice) {
                        System.out.println ("Wake up early");
                        System.out.println ("Have breakfast");
                        System.out.println ("Get ready for office");
                        System.out.println ("Get the bus");
                        System.out.println ("Join office");
                    } else {
                        System.out.println ("long sleep");
                    }
                }
            }
        }
        // Old style switch-case
//        switch (day) {
//            // Saturday & sunday is weekend
//            case "Saturday":
//            case "Sunday":
//                System.out.println ("Weekend");
//                break;
//            // Any other day is a regular day. In that case check if the user has any emergency or has office
//            default:
//                if (hasEmergency) {
//                    System.out.println ("Has some emergency. Postpone all schedules");
//                } else {
//                    if (hasOffice) {
//                        System.out.println ("Wake up early");
//                        System.out.println ("Have breakfast");
//                        System.out.println ("Get ready for office");
//                        System.out.println ("Get the bus");
//                        System.out.println ("Join office");
//                    } else {
//                        System.out.println ("long sleep");
//                    }
//                }
//                break;
//        }
    }
}
