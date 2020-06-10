package ru.geekbrain.main.site.at.examples.arrayList;

import ru.geekbrain.main.site.at.examples.equals.Dog;

import java.util.ArrayList;
import java.util.List;

public class Сontains {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(001));
        dogs.add(new Dog(002));
        dogs.add(new Dog(003));
        dogs.add(new Dog(004));
        dogs.add(new Dog(005));
        dogs.add(0,new Dog(01));


        System.out.println(dogs.contains(new Dog(002)));
        System.out.println(dogs.contains(new Dog(004)));
    }
}
