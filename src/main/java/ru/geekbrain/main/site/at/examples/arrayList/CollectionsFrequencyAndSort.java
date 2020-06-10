package ru.geekbrain.main.site.at.examples.arrayList;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsFrequencyAndSort {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Аня");
        names.add("Паша");
        names.add("Ваня");
        names.add("Аня");
        names.add("Дима");

        System.out.println(Collections.frequency(names,"Аня"));
        Collections.sort(names);
        System.out.println(names);
    }
}
