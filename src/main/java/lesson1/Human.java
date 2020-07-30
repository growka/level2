package lesson1;

public class Human implements Members {

    private int canRun;
    private int canJump;
    private boolean onDistance;


    public Human(int canRun, int canJump) {

        this.canRun = canRun;
        this.canJump = canJump;
        this.onDistance = true;
    }

    @Override
    public void run(String type, int distance) {
        if (type.equals("treadmill")) {
            if (canRun >= distance) {
                System.out.println("Человек пробежал " + distance + " метров.");
            } else {
                System.out.println("Человек не смог пробежать " + distance + "метров. Дистанция очень большая! Сход с дистанции!");
                onDistance = false;
            }
        }
    }

    @Override
    public void jump(String type, int height) {
        if (type.equals("wall")) {
            if (canJump >= height) {
                System.out.println("Человек перепрыгнул " + height + " метров.");
            } else {
                System.out.println("Человек не смог перепрыгнуть " + height + "метров. Стена очень большая! Сход с дистанции!");
                onDistance = false;
            }
        }
    }


        public boolean getOnDistance() {
        return onDistance;
    }

        public int getRun () {
            return canRun;
        }

        public int getJump () {
            return canJump;
        }
    }



