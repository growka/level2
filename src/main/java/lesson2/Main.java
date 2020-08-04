package lesson2;


class MyArraySizeException extends Exception {

    public MyArraySizeException(String msg){
           super(msg);
    }
}

class MyArrayDataException extends Exception {

    public MyArrayDataException(String msg){
        super(msg);
    }
}


public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] array44 = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        // no exception

        //String[][] array44_bad = {{"1", "a", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        //MyArrayDataException

        String[][] array33 = {{"1", "2", "3"}, {"1", "2", "3"}};

        getArray(array44);
        // no exception
        getArray(array33);
        // MyArraySize exception
        //getArray(array44_bad);



    }


    public static void getArray(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int row, column, sum = 0;

        row = array.length;
        column = array[0].length;

        if (array.length == 4 && array[0].length == 4) {
            System.out.println("It's OK!");
        } else {
            throw new MyArraySizeException("MyArraySizeException: Wrong size! (not 4x4)");
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException("MyArrayDataException: Unable to convert " + i + " : " + j);
                }
            }
        }
        System.out.println(sum);
    }
}
