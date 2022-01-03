package com.pondit.b4.class17;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesClassExample {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));

        try (InputStream input = new FileInputStream("test.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("test.message"));
            System.out.println(prop.getProperty("wijwoiowjef"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
