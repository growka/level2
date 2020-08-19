import java.util.Arrays;
import java.util.concurrent.TransferQueue;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {


        calculationOne(arrayCreate());
        calculationTwo(arrayCreate());

    }

    private static float[] arrayCreate() {

        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        return arr;
    }

    private static void calculationOne(float[] arr) {

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }

        System.out.println(System.currentTimeMillis()-t1);

    }

    private static void calculationTwo(float[] arr) {

        long t2 = System.currentTimeMillis();

        float[] arrOne = new float[h];
        System.arraycopy(arr, 0, arrOne, 0, h);
        float[] arrTwo = new float[h];
        System.arraycopy(arr, h, arrTwo, 0, h);

        Thread firstArrayCalculation = new Thread(() -> {
            for (int i = 0; i <arrOne.length ; i++) {
                arrOne[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        firstArrayCalculation.start();

        Thread secondArrayCalculation = new Thread(() -> {
            for (int i = 0; i <arrTwo.length ; i++) {
                arrTwo[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        secondArrayCalculation.start();

        System.arraycopy(arrOne, 0, arr, 0, h);
        System.arraycopy(arrTwo, 0, arr, h, h);

        System.out.println(System.currentTimeMillis() - t2);
    }

}

