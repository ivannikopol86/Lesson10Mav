package Lesson10.Exercise3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {
    public static void countWords() {
        File pathToFile = new File("C:\\Users\\Pc\\IdeaProjects\\Lesson 10\\src\\Lesson10\\words.txt");
        Map<String, Integer> map = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strings = line.split("\\W");
                for (String word : strings) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            System.out.println(list);
        } catch (FileNotFoundException e) {
            System.err.println("Cannot find file " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        countWords();
    }
}
