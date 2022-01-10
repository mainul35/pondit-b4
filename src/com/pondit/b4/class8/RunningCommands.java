package com.pondit.b4.class8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningCommands {
    public static void main(String[] args) throws IOException, InterruptedException {
        var runtime = Runtime.getRuntime();
        var br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && !line.isBlank()) {
            var process = runtime.exec(line);
            var is = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);

            }
        }
    }
}
