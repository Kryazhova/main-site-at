package ru.geekbrain.main.site.at.examples.equals;

import java.util.Objects;

public class Dog {
    private String name;
    private String breed;
    private int age;
    private int weight;
    private int dog;
    private boolean gender;

    private int dogPassportNumber;


    public Dog(int dogPassportNumber) {
        this.dogPassportNumber = dogPassportNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return dogPassportNumber == dog.dogPassportNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed, age, weight, dog, gender, dogPassportNumber);
    }

    @Override
    public String toString() {
        return "Dog{" +
//                "name='" + name + '\'' +
//                ", breed='" + breed + '\'' +
//                ", age=" + age +
//                ", weight=" + weight +
//                ", dog=" + dog +
//                ", gender=" + gender +
//                ", " +
                "dogPassportNumber=" + dogPassportNumber +
                '}';
    }
}
