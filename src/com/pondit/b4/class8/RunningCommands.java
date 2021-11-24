package com.pondit.b4.class8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningCommands {
    public static void main(String[] args) throws IOException {
        var process = Runtime.getRuntime().exec("git status");

        var is = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
    }
}
