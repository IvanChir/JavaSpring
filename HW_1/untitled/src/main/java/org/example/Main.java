package org.example;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Создание объекта Person
        Person person = new Person("Иван", "Иванов", 30);

        // Сериализация объекта в JSON
        String json = gson.toJson(person);
        System.out.println("Сериализованный JSON: " + json);

        // Десериализация JSON обратно в объект Person
        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println("Десериализованный объект: " + deserializedPerson);
    }
}