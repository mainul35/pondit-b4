package com.pondit.b4.class18.enums;

import javax.swing.*;
import java.time.DayOfWeek;
import java.util.Arrays;

public class EnumTest {

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Hello from Pondit B4","Hello", JOptionPane.QUESTION_MESSAGE);

        DayOfWeek dayOfWeek = DayOfWeek.WEDNESDAY;

        Arrays.stream(DayOfWeek.values()).filter(dayOfWeek1 -> dayOfWeek1.equals(dayOfWeek)).forEach(dayOfWeek1 -> {
            System.out.println("Today is "+ dayOfWeek1);
        });
    }
}
