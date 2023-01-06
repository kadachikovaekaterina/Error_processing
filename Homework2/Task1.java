package Homework2;

import java.util.Scanner;



public class Task1 {
    public static void main(String[] args) {
        // Реализуйте метод, который запрашивает у пользователя ввод дробного числа
        // (типа float), и возвращает введенное значение.
        // Ввод текста вместо числа не должно приводить к падению приложения,
        // вместо этого, необходимо повторно запросить у пользователя ввод данных.
        System.out.println(getFloat());
    }

    public static float getFloat() {
        float input = 0f;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите дробное число: ");
            if (scanner.hasNextFloat()) {
                input =  scanner.nextFloat();
                break;
            }
        }
        return input;
    }
}
