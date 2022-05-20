package com.pondit.b4.class8;

import java.io.*;
import java.util.Arrays;

public class RunningCommands {
    public static void main(String[] args) throws IOException, InterruptedException {
        var pb = new ProcessBuilder();
        var br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.print(">> ");
        if (System.getProperty("os.name").equalsIgnoreCase("linux") || System.getProperty("os.name").equalsIgnoreCase("mac") ) {
            runWithPrivileges();
            // TODO: Pull ubuntu docker image
//            runUbuntuDockerImage();
            // TODO: Create ubuntu container
            // TODO: exec -it inside docker container
        }

        while ((line = br.readLine()) != null && !line.isBlank()) {
            if (line.contains("powershell") || line.contains("cmd")) {
                System.err.println("\nUnable to execute command: " + line);
                System.out.println(">> ");
                continue;
            }
            if (System.getProperty("os.name").equalsIgnoreCase("linux") || System.getProperty("os.name").equalsIgnoreCase("mac") ) {
                pb.command("/bin/bash", "-c", line);
            } else {
                pb.command("powershell.exe", "/c", line);
            }
            executeCommand(pb);
        }
    }

    private static void executeCommand(ProcessBuilder pb) throws IOException, InterruptedException {
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

    private static void runUbuntuDockerImage() throws IOException, InterruptedException {
        var pb = new ProcessBuilder("/bin/bash", "-c", "sudo docker run -it ubuntu:latest");
        executeCommand(pb);
    }

    public static boolean runWithPrivileges() {
        InputStreamReader input;
        OutputStreamWriter output;

        try {
            //Create the process and start it.
            Process pb = new ProcessBuilder(new String[]{"/bin/bash", "-c", "/usr/bin/sudo -S /bin/cat /etc/sudoers 2>&1"}).start();
            output = new OutputStreamWriter(pb.getOutputStream());
            input = new InputStreamReader(pb.getInputStream());

            int bytes, tryies = 0;
            char buffer[] = new char[1024];
            while ((bytes = input.read(buffer, 0, 1024)) != -1) {
                if(bytes == 0) {
                    continue;
                }
                //Output the data to console, for debug purposes
                String data = String.valueOf(buffer, 0, bytes);
                System.out.println(data);
                // Check for password request
                if (data.contains("[sudo] password")) {
                    // Here you can request the password to user using JOPtionPane or System.console().readPassword();
                    // I'm just hard coding the password, but in real it's not good.
                    char password[] = new char[]{'*'};
                    output.write(password);
                    output.write('\n');
                    output.flush();
                    // erase password data, to avoid security issues.
                    Arrays.fill(password, '\0');
                    tryies++;
                }
            }

            return tryies < 3;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
