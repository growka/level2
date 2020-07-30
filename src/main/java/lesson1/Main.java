package lesson1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Members[] members = new Members[3];
        Barrier[] barriers = new Barrier[5];
        Random random = new Random();

        System.out.println("Участники:");
        System.out.println();

        int distance = 5 + random.nextInt(5);
        int heigth = 5 + random.nextInt(5);
        members[0] = new Human(distance, heigth);
        System.out.println("Человек: прыжок - " + members[0].getJump() + " м., дорожка - " + members[0].getRun() + " м.");

        distance = 7 + random.nextInt(5);
        heigth = 7 + random.nextInt(5);
        members[1] = new Robot(distance, heigth);
        System.out.println("Робот: прыжок - " + members[1].getJump() + " м., дорожка - " + members[1].getRun() + " м.");

        distance = 4 + random.nextInt(5);
        heigth = 4 + random.nextInt(5);
        members[2] = new Cat(distance, heigth);
        System.out.println("Кот: прыжок - " + members[2].getJump() + " м., дорожка - " + members[2].getRun() + " м.");

        System.out.println();

        boolean isWall;
        int size;
        System.out.println("Полоса препятствий:");
        System.out.println();
        for (int i = 0; i < barriers.length; i++) {
            size = 3 + random.nextInt(5);
            isWall = random.nextBoolean();
            if (isWall) {
                barriers[i] = new Wall(size);
                System.out.println("Стена " + size + " метров.");
            } else {
                barriers[i] = new Treadmill(size);
                System.out.println("Беговая дорожка " + size + " метров.");
            }
        }

        System.out.println();
        System.out.println("--------------Начало испытаний--------------");
        System.out.println();
        // наверное, логику проверки "стена или дорожка" (и, соответвенно, "бежать или прыгать") правильнее было бы засунуть сюда, но что сделано, то сделано))))
        for (int i = 0; i < members.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                if (members[i].getOnDistance()) {
                    members[i].jump(barriers[j].type, barriers[j].getBarrier());
                    members[i].run(barriers[j].type, barriers[j].getBarrier());
                 } else {
                    break;
                }
            }
            System.out.println();
        }
    }
}




