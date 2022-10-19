package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    public static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        String[] cities = {"Москва", "Якутск", "Ханты-Мансийск", "Екатеринбург", "Магадан"};
        Random rnd = new Random();
        int i = rnd.nextInt(cities.length);
        return cities[i];
    }

    public static String generateName() {
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String ru) {
            return new UserInfo(generateCity(), generateName(), generatePhone());
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
