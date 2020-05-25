package ru.geekbrains.main.site;

public class Human implements Move{
    private String name;
    int powerRun;
    int powerJump;

    public Human(String name) {
        this.name=name;
        powerRun = 15-8+(int)(Math.random()*16);
        powerJump = 2-1+(int)(Math.random()*2);
        // описала в cat
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

    @Override
    public void run() {
        System.out.println(name+" бежит на 2 ногах");
    }

    @Override
    public void jump() {
        System.out.println(name+" прыгает");
    }


}
