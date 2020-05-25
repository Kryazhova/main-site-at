package Homework_1;

import java.util.Random;

public class Cat implements Move{
    String name;
    int powerRun;
    int powerJump;

    public Cat(String name) {
        this.name=name;
        powerRun = 10-2+(int)(Math.random()*4);
        powerJump = 5-1+(int)(Math.random()*2);
        // использовала random чтобы кошечки имели разный потенциал, и вычисляю так, чтобы с одинаковой вероятностью
        // кошка потеряла силу при создании или увеличила (например, для run - на 2 ед.)
    }

    public String getName() {
        return name;
    }

    public int getPowerRun() {
        return powerRun;
    }

    public int getPowerJump() {
        return powerJump;
    }

    //@Override
    public void run() {
        System.out.println(name+" бежит на 4 лапах");
    }

    //@Override
    public void jump() {
        System.out.println(name + " красиво прыгает");
    }
}