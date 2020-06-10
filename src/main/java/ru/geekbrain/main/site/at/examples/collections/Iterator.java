package ru.geekbrain.main.site.at.examples.collections;

import java.util.ArrayList;
import java.util.List;

public class Iterator {
    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();
        cats.add("Первый кот");
        cats.add("Второй кот");
        cats.add("Третий кот");

        java.util.Iterator<String> iterator = cats.iterator();

        while (iterator.hasNext()) {
//            iterator.remove(); Удаляет сами элементы
            System.out.println(iterator.next());
        }

        for (String cat : cats) {
            System.out.println(cat);
        }
    }
}
