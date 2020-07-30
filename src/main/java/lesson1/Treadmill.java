package lesson1;

public class Treadmill extends Barrier {

    public Treadmill (int distance) {
        this.type = "treadmill";
        this.distance = distance;
    }

    private int distance;

    public int getBarrier() {

        return distance;
    }

}
