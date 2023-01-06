package Homework2;

public class Task2 {
    public static void main(String[] args) {
        int index = 8;
        int[] intArray = new int[index];
        int d = 0;
        if (d == 0) {
            throw new ArithmeticException("Catching exception: division by zero ");
        }
        if (index >= intArray.length) {
            throw new IndexOutOfBoundsException("Catching exception: index out of bounds ");

        }
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);

    }
}
