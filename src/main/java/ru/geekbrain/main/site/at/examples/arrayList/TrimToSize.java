package ru.geekbrain.main.site.at.examples.arrayList;

import ru.geekbrain.main.site.at.examples.equals.Dog;

import java.util.ArrayList;

public class TrimToSize {
    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(001));
        dogs.add(new Dog(002));
        dogs.add(new Dog(003));
        dogs.add(new Dog(004));
        dogs.add(new Dog(005));
        dogs.add(0,new Dog(01));
       // теперь пустые ячейки, которые были заложены заранее для следующих элементов
       // удалены, то есть capacity = size
        dogs.trimToSize();

        System.out.println(dogs);

    }
}
