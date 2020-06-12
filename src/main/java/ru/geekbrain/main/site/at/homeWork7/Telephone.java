package ru.geekbrain.main.site.at.homeWork7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telephone {

    Map<String, ArrayList<String>> noted = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        if (testPhoneNumber(phoneNumber)==false){
            throw new IllegalArgumentException("Неверный телефон: " + surname);
        }
        if (!noted.containsKey(surname)){
            noted.put(surname,new ArrayList<>());
        }
        noted.get(surname).add(phoneNumber);
    }

    public void get(String surname){
        System.out.println("Номер телефона: " + surname + " / " + noted.get(surname));
    }

    public static boolean testPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("(8|\\+7)(\\d{10}|\\(\\d{3}\\)\\d{7})");
        Matcher mather = pattern.matcher(phoneNumber);
        return mather.matches();
    }


}
