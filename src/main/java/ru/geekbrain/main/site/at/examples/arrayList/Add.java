package ru.geekbrain.main.site.at.examples.arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Add {

    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();
        cats.add("Первый кот");
        cats.add("Второй кот");
        cats.add("Третий кот");

        Iterator<String> iterator = cats.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
