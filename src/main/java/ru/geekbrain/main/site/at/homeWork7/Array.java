package ru.geekbrain.main.site.at.homeWork7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Array {
    public static void main(String[] args) {
    ArrayList<String> literaryGenre = new ArrayList<>();
        literaryGenre.add("Повесть");
        literaryGenre.add("Очерк");
        literaryGenre.add("Новелла");
        literaryGenre.add("Пьесса");
        literaryGenre.add("Рассказ");
        literaryGenre.add("Эпос");
        literaryGenre.add("Ода");
        literaryGenre.add("Эпопея");
        literaryGenre.add("Роман");
        literaryGenre.add("Очерк");
        literaryGenre.add("Эссе");


        literaryGenre.add(9,"Повесть");
        literaryGenre.set(11,"Повесть");
        literaryGenre.add("Ода");

        //получение списка уникальных элементов
        LinkedHashSet<String> uniqueArray = new LinkedHashSet<>(literaryGenre);
        System.out.println(uniqueArray);

        //для каждого уникального элемента считает количество упомнинай в списке literaryGenre
        for (String countElement:uniqueArray){
            System.out.println(countElement + " встречается в  списке " +
                    Collections.frequency(literaryGenre, countElement));
        }
    }
}
