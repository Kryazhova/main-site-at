package Homework_1;

public class Track {
    static int length;

    public static void track(int powerRun,int length) {
        if (length <= powerRun) Marathon.toDo = true;
        else Marathon.toDo = false;
    }
}

