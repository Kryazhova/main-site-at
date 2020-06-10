package ru.geekbrain.main.site.at.examples.hashSet;

import ru.geekbrain.main.site.at.examples.equals.Dog;

import java.util.HashSet;

public class Clone {
    public static void main(String[] args) {

        HashSet<Dog> dogs = new HashSet<>();
        dogs.add(new Dog(001));
        dogs.add(new Dog(001));
        dogs.add(new Dog(002));
        dogs.add(new Dog(003));

        System.out.println(dogs.contains(002));
        System.out.println(dogs.contains(new Dog(001)));

        dogs.clone();
    }
}
