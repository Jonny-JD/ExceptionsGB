package org.jimmydv.util;

import org.jimmydv.exceptions.WrongDataFormatException;
import org.jimmydv.exceptions.WrongDataLengthException;

import java.util.Arrays;


public abstract class Validator {
    public static boolean isValidInput(String input) {
        if (!input.isEmpty()) {
            String[] data = input.split(" ");
            final int DATA_LENGTH = 6;
            if (data.length < DATA_LENGTH) {
                throw new WrongDataLengthException("Not enough data! Should contain exactly six positions");
            }
            if (data.length > DATA_LENGTH) {
                throw new WrongDataLengthException("Too much data! Should contain exactly six positions");
            }
            return isValidUsername(Arrays.copyOfRange(data,0, 3)) &&
            isValidBirthDate(data[3]) &&
            isValidPhoneNumber(data[4]) &&
            isValidSex(data[5]);
        }
        throw new WrongDataLengthException("Not enough data! Should contain exactly six positions");
    }

    private static boolean isValidBirthDate(String birthdate) {
        if (!birthdate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new WrongDataFormatException("Wrong date format! Should be dd.mm.yyyy");
        }
        return true;
    }

    private static boolean isValidUsername(String[] username) {
        if (Arrays.stream(username)
                .anyMatch(s -> s.matches("\\W")))
            throw new WrongDataFormatException("Username should contains only letters!");
        return true;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            throw new WrongDataFormatException("Incorrect phone number format!");
        }
        return true;
    }

    private static boolean isValidSex(String sex) {
        if (!sex.matches("[fm]")) {
            throw new WrongDataFormatException("Wrong sex format! Possible options is \\\"f\\\" or \\\"m\\\"");
        }
        return true;
    }
}
