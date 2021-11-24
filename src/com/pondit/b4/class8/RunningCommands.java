package com.pondit.b4.class8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningCommands {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] commands = new String[] {"ls", "git add .", "git commit -m 'committing with java code'"};
        var runtime = Runtime.getRuntime();
        for (int i = 0; i < commands.length; i++) {
            var process = runtime.exec(commands[i]);
            var is = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        }
    }
}
