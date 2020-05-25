package ru.geekbrains.main.site;

public class Wall {
     int[] high;

    public static void wall(int powerRun,int high) {
        if (high <= powerRun) Marathon.toDo = true;
        else Marathon.toDo = false;
    }
    }

