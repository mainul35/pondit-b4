package com.pondit.b4.class21_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class ReadingClasses {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        scanClasses("com.pondit.b4.class21_22");
    }

    /**
     * 1. Check a package
     * 2. Check if the content contains a .
     * 2.1.1. If yes, check if it is a class file
     * 2.2.1. If No, check if it is a folder by using class loader
     * 2.2.2. If it is a folder, concat the folder name with the package name
     * 2.2.3. go to step 1
     * */
    private static void scanClasses(String packageName) throws IOException {
        var uri = packageName.replaceAll("[.]", "/");
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream(uri);
        assert stream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String p = "";
        while ((p = reader.readLine())!= null) {
            if (!p.isBlank() && p.contains(".class")) {
                var clazz = getClass(p, packageName);
                System.out.println(clazz);
            } else if (!p.contains(".")){
                var path = Paths.get(ClassLoader.getSystemClassLoader().getResource(uri).getPath());
                if(Files.isDirectory(path)) {
                    scanClasses(packageName+"."+p);
                }
            }
        }
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}

