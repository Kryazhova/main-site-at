package ru.geekbrains.main.site;

public interface Move{
    void run();
    void jump();
    int getPowerRun();
    int getPowerJump();
    String getName();
}
