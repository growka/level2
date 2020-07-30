package lesson1;

public class Wall extends Barrier {


    public Wall(int height) {
        this.type = "wall";
        this.height = height;
    }

    private int height;

    @Override
    public int getBarrier() {
        return height;
    }


}


