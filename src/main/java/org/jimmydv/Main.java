package org.jimmydv;

import org.jimmydv.entity.User;
import org.jimmydv.exceptions.UserInputException;
import org.jimmydv.util.UserParser;
import org.jimmydv.util.Validator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    static {
        File usersFolder = new File("users");
        if (!usersFolder.exists()) {
            usersFolder.mkdir();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Please enter the required user data split with spaces:
                firstname (text)
                lastname (text)
                patronymic (text)
                birthdate (dd.mm.yyyy)
                phone number (number)
                sex (f or m)
                
                for example: Ivanov Ivan Ivanovich 01.07.1917 778899 m
                
                input:
                """);
        String input = scanner.nextLine();
        saveUserData(input);
    }

    private static void saveUserData(String input) {
        try {
            if (Validator.isValidInput(input)) {
                User user = UserParser.parseUser(input);

                File userFile = new File("users"
                        + FileSystems.getDefault().getSeparator()
                        + user.getFirstname() + "_" + user.getLastname());
                if (!userFile.exists()) {
                    Files.createFile(Path.of(userFile.toURI()));
                }

                try (FileWriter writer = new FileWriter(userFile, true)) {
                    writer.write(user + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } catch (UserInputException e) {
            System.err.println(e.getMessage());
        }
    }
}