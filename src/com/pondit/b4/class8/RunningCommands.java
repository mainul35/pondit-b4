package com.pondit.b4.class8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunningCommands {
    public static void main(String[] args) throws IOException, InterruptedException {
        var pb = new ProcessBuilder();
        var br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        System.out.print(">> ");
        while ((line = br.readLine()) != null && !line.isBlank()) {
            if (line.contains("powershell") || line.contains("cmd") || line.contains("terminal")) {
                System.err.println("\nUnable to execute command: " + line);
                continue;
            }
            pb.command("powershell.exe", "/c", line);
            var process = pb.start();
            process.waitFor();
            if (process.exitValue() != 0) {
                System.out.println();
                InputStream errorStream = process.getErrorStream();
                int c = 0;
                while ((c = errorStream.read()) != -1) {
                    System.err.print((char)c);
                }
                if (errorStream.available() == 0) {
                    System.out.print(">> ");
                }
            } else {
                var is = process.getInputStream();
                try (var reader = new BufferedReader(new InputStreamReader(is))) {
                    String output;
                    while ((output = reader.readLine()) != null) {
                        System.out.println(output);
                    }
                    System.out.print(">> ");
                }
            }
        }
    }
}
