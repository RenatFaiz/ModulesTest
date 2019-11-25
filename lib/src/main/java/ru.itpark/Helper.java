package ru.itpark;

import com.github.javafaker.Faker;

public class Helper {
    public String generate() {
        final Faker faker = new Faker();
        return faker.name().name();
    }
}
