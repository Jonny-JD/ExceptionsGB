package org.jimmydv.entity;

import java.time.LocalDate;

public class User {
    private final String firstname;
    private final String lastname;
    private final String patronymic;
    private final LocalDate birthdate;
    private final int phoneNumber;
    private final char sex;

    private User(Builder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
        this.patronymic = builder.patronymic;
        this.birthdate = builder.birthdate;
        this.phoneNumber = builder.phoneNumber;
        this.sex = builder.sex;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public char getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthdate=" + birthdate +
                ", phoneNumber=" + phoneNumber +
                ", sex=" + sex +
                '}';
    }

    public static class Builder {
        private String firstname;
        private String lastname;
        private String patronymic;
        private LocalDate birthdate;
        private int phoneNumber;
        private char sex;

        public Builder() {
        }

        public Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder patronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder birthDate(LocalDate birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder phoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder sex(char sex) {
            this.sex = sex;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
