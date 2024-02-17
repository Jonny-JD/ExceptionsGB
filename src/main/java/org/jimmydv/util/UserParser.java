package org.jimmydv.util;

import org.jimmydv.entity.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public abstract class UserParser {
    public static User parseUser(String input) throws ParseException {
        String[] data = input.split(" ");
        return new User.Builder()
                .firstname(data[0])
                .lastname(data[1])
                .patronymic(data[2])
                .birthDate(LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .phoneNumber(Integer.parseInt(data[4]))
                .sex(data[5].charAt(0))
                .build();
    }

}
