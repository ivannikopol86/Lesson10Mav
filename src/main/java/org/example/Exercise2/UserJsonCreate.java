package Lesson10.Exercise2;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserJsonCreate {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {

        File pathToWriteFile = new File("C:\\Users\\Pc\\IdeaProjects\\Lesson 10\\src\\Lesson10\\users.json");
        File pathToReadFile = new File("C:\\Users\\Pc\\IdeaProjects\\Lesson 10\\src\\Lesson10\\names.txt");

        String json;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToReadFile))) {
            String line;

            List<User> users = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                User user = new User();
                String[] array = line.trim().split(" ");
                if (array.length == 2 && array[0] != null && Integer.parseInt(array[1]) > 0) {
                    user.setName(array[0]);
                    user.setAge(Integer.parseInt(array[1]));
                    users.add(user);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToWriteFile))) {
                json = GSON.toJson(users);
                writer.write(json);
                System.out.println(json);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("You provide an invalid data. Name cannot be null and age cannot be less than 0.");
        }

    }



}

