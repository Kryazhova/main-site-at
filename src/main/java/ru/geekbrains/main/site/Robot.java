package ru.geekbrains.main.site;

public class Robot implements Move  {
    private String name;
    int powerRun;
    int powerJump;

    public Robot(String name) {
        this.name=name;
        powerRun = 2-1+(int)(Math.random()*2);
        powerJump = 0;
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
        System.out.println(name+" пытается бежать");
    }
    @Override
    public void jump() {
        System.out.println(name+" не умеет прыгать");
    }

}
