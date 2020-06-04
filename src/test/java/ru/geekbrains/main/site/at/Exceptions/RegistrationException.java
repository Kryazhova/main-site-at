package ru.geekbrains.main.site.at.Exceptions;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistrationException {
    @Test
    void example(){
        File file = new File("src/test/resources/txt.txt");

        try {
            new Scanner(file);
            System.out.println("Блок, который мы пытвемся сделать;");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Блок если получили ошибку");
        }finally {
            System.out.println("Блок который всегда делаем, успешный или неуспешный кейс");
        }

        System.out.println("Программа выполняется дальше!");
    }
}
