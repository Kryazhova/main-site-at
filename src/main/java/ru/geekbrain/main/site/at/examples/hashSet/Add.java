package ru.geekbrain.main.site.at.examples.hashSet;

import java.util.HashSet;
import java.util.Set;

public class Add {
    public static void main(String[] args) {
        Set<String> cats = new HashSet<>();
        cats.add("Первый кот");
        cats.add("Второй кот");
        cats.add("Третий кот");

        System.out.println(cats);
        System.out.println(cats.size());
    }
}
