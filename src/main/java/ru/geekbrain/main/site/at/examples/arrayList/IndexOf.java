package ru.geekbrain.main.site.at.examples.arrayList;

import ru.geekbrain.main.site.at.examples.equals.Dog;

import java.util.ArrayList;
import java.util.List;

public class IndexOf {
    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(0000));
        dogs.add(new Dog(0003));
        dogs.add(new Dog(0001));
        dogs.add(new Dog(0002));
        dogs.add(new Dog(0003));


        System.out.println();

        System.out.println(dogs.indexOf(new Dog(0003)));
    }
}
