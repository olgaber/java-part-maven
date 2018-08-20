package com.academy.lesson17;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Names {

    public static void main(String[] args) {


        String path = "женские имена.txt";
        String pathSorted = "sorted.txt";

        OutputStream os = null;
        try {
            os = new FileOutputStream(pathSorted);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try(OutputStreamWriter osw = new OutputStreamWriter(os);) {

            osw.write("Test");

            Files.lines(Paths.get(path))
                    .filter(s -> s.startsWith("И"))
                    .sorted((s1, s2) -> s2.compareTo(s1))
//                    .peek(System.out::println);
                    .peek(s -> {
                        try {
//                            System.out.println(s);
                            osw.write(s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    })
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
