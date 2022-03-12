package com.pondit.b4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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

class Main {
    static class Spoon {
        private Diner owner;
        public Spoon(Diner d) { owner = d; }
        public Diner getOwner() { return owner; }
        public synchronized void setOwner(Diner d) { owner = d; }
        public synchronized void use() {
            System.out.printf("%s has eaten!", owner.name);
        }
    }

    static class Diner {
        private String name;
        private boolean isHungry;

        public Diner(String n) { name = n; isHungry = true; }
        public String getName() { return name; }
        public boolean isHungry() { return isHungry; }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                if (spoon.owner != this) {
                    try { Thread.sleep(1); }
                    catch(InterruptedException e) { continue; }
                    continue;
                }

                if (spouse.isHungry()) {
                    System.out.printf("%s: You eat first my darling %s!%n",
                            name, spouse.getName());
                    spoon.setOwner(spouse);
                    continue;
                }

                spoon.use();
                isHungry = false;
                System.out.printf("%s: I am stuffed, my darling %s!%n",
                        name, spouse.getName());
                spoon.setOwner(spouse);
            }
        }
    }

    public static void main(String[] args) {

        Set<? super Number> numberSet = new HashSet<>();
        numberSet.add(2);
        numberSet.add(3);

        final Diner husband = new Diner("Bob");
        final Diner wife = new Diner("Alice");
        final Spoon s = new Spoon(husband);
        new Thread(() -> husband.eatWith(s, wife)).start();
        new Thread(() -> wife.eatWith(s, husband)).start();
    }
}
