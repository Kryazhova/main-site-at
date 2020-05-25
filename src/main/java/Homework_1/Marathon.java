package Homework_1;

import java.util.ArrayList;

public class Marathon {
    static ArrayList<Move> members = new ArrayList();
    public static boolean toDo;
    public Marathon() {
    }

    public static void main(String[] args) {
        members.add(new Cat("Мурка"));
        members.add(new Cat("Мазурка"));
        members.add(new Human("Адам"));
        members.add(new Human("Ева"));
        members.add(new Robot("Hoover"));
        members.add(new Robot("r2-d2"));


        for (Move starts : members) {
            starts.jump();
            starts.run();
        }

        System.out.println("Теперь мы видели всех участников! Начнем!");

        //у нас одинаковое количество препятствий для разных блоков
        //сделала 3 массива, не смогла придумать,как в 1 массив и бег и прыжки внести
        int[] length = {1, 3, 5, 10, 15};
        int[] high = {1,2,3,4,5};

            for (Move starts : members) {
                for (int a = 0; a < 5; a++) {
                    int l = length[a];
                    int h = high[a];
                    Track.track(starts.getPowerRun(), l);
                    if (toDo == true) {
                        System.out.println(starts.getName() + " преодолел " + l + " км");
                        Wall.wall(starts.getPowerJump(),h);
                        if (toDo==true) System.out.println(starts.getName() + " перепрыгнул " + h + " м");
                        else  {
                            System.out.println(starts.getName() + " не смог перепрыгнуть " + h + " м. Снят с дистанции");
                            System.out.println("______________");
                            break;
                        }
                    }
                    else {
                        System.out.println(starts.getName() + " не смог преодолеть  " + l + " км. Снят с дистанции");
                        System.out.println("______________");
                        break;
                    }
                }
            }
    }
}


// другие попытки решения
//    попытка 1
//    Cat cats = new Cat("Мурка");
//    Human man = new Human("Антон");
//    Robot robot = new Robot("r2-d2");
//    Move[] members = {cat,man,robot};
//      не хочу отдельно прописывать имена созданных животных в массив, ведь их может быть очень много
//      решила сразу делать через массив
//
//  попытка 2
//  static Cat[] cats = new Cat [3]
//     но мне не понравилось, что должно быть имеено 3 кота, захотела массив без размера
//  int count_cat = cats.size();
//  for (int a=0; a<=count_cat;a++){
//     cats[a].jump();
//     cats[a].run();
//  }

//  попытка 3 - получилось для кажного списка свой цикл, это тоже длинное и не удобное решение.
//  нашла, как объединить списки в 1 общий
//        for (Cat kitty:cats){
//            kitty.jump();
//            kitty.run();
//        }
//        for (Human people:man){
//            people.jump();
//            people.run();
//        }
//        for (Robot rt:robots){
//            rt.jump();
//            rt.run();
//        }

//   вариант 4 - можно было сразу в 1 записать, но зато выучила метод объединения массивов))
//    static ArrayList<Human> man = new ArrayList();
//    static ArrayList<Robot> robots = new ArrayList();
//
//        cats.add(new Cat("Мурка"));
//        cats.add(new Cat("Мазурка"));
//        man.add(new Human("Адам"));
//        man.add(new Human("Ева"));
//        robots.add(new Robot("Алита"));
//        robots.add (new Robot("r2-d2"));

//        ArrayList<Move> members = new ArrayList<Move>(cats);
//        members.addAll(man);
//        members.addAll(robots);
