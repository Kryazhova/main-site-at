package ru.geekbrain.main.site.at.examples.hashSet;

import ru.geekbrain.main.site.at.examples.equals.Dog;

import java.util.HashSet;
import java.util.Set;

public class Contains {
    public static void main(String[] args) {

        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog(001));
        dogs.add(new Dog(001));
        dogs.add(new Dog(002));
        dogs.add(new Dog(003));

        System.out.println(dogs.contains(002));
        System.out.println(dogs.contains(new Dog(001)));
    }
}
