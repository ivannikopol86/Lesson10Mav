package org.example.Exercise1;

import java.io.*;


public class CallerID {
    public static void printNumbers() throws IOException {

    File file = new File("./src/main/java/org/example/phoneNumbers.txt");
        System.out.println("file.exists() = " + file.exists());


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s", "");
                if (line.length() > 10) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No file " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {
        printNumbers();


    }



}
