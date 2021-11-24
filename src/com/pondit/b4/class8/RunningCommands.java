package com.pondit.b4.class8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunningCommands {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] commands = new String[] {"ls", "git add .", "git commit -m 'committing with java code'"};
        var runtime = Runtime.getRuntime();
        for (int i = 0; i < commands.length; i++) {
            final var process = runtime.exec(commands[i]);
            new Thread() {
                @Override
                public void run() {
                    var is = process.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                    String s = "";
                    while (true) {
                        try {
                            if ((s = bufferedReader.readLine()) == null) break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println(s);
                    }
                }
            }.start();

        }
    }
}
