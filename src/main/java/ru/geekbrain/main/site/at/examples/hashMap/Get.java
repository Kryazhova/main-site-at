package ru.geekbrain.main.site.at.examples.hashMap;

import ru.geekbrain.main.site.at.examples.equals.Dog;
import ru.geekbrain.main.site.at.examples.equals.Human;

import java.util.HashMap;
import java.util.Map;

public class Get {
    public static void main(String[] args) {
        Map<Human, Dog> dogs = new HashMap<>();

        System.out.println(dogs.isEmpty());

        dogs.put(
                new Human("Первый хозяин"),
                new Dog(001));

        dogs.put(
                new Human("Второй хозяин"),
                new Dog(002));

        dogs.put(
                new Human("Третий хозяин"),
                new Dog(003));


        System.out.println(dogs.get( new Human("Первый хозяин")));

        System.out.println(dogs.keySet());

        System.out.println(dogs.values());
    }
}
