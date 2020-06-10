package ru.geekbrain.main.site.at.examples.equals;

public class Start {
    public static void main(String[] args) {
        Dog dog1 = new Dog(55443322);
        Dog dog2 = new Dog(55443322);
        Cat cat = new Cat (55443322);

        System.out.println(dog1.equals(dog2));
    }

}
