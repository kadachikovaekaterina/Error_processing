package Homework3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {

            try {
                String[] result = makeData(addUserInput());
                checkFIO(result);
                checkBirthdate(result);
                checkNumber(result);
                checkGender(result);
                writeData(result);
                break;

            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод номера телефона. Введите цифры.");
                continue;

            } catch (DateTimeParseException e) {
                System.out.println("Вы ввели некорректный формат даты. Нужен dd.mm.yyyy");
                continue;
            } catch (MoreDataExeption e) {
                System.out.println(
                        "Вы ввели больше данных чем нужно. Введите только необходимые данные. Следуйте инструкции в консоле");
                continue;
            } catch (LessDataExeption e) {
                System.out.println(
                        "Вы ввели меньше данных чем нужно. Введите только необходимые данные. Следуйте инструкции в консоле");
                continue;
            } catch (IncorrectFIOException e) {
                System.out.println("Некорректно заполнено поле ФИО. Формат: Фамилия, Имя, Отчество");
                continue;
            } catch (IncorrectGenderException e) {
                System.out.println("Некорректно введен пол. f - если женский, m - усли мужской");
                continue;
            }
        }

    }

    public static String addUserInput() {
        System.out.println(
                "\nВас приветствует программа <База данных>!");
        System.out.println(
                "Введите данные через ПРОБЕЛ в следующем формате:\n<Фамилия>,<Имя>,<Отчество> <Дата рождения в формате dd.mm.yyyy> <Номер телефона. Целое число> <Пол. f - жен. или m - мужской>");
        String input = "";
        Scanner scanner = new Scanner(System.in);
        try{
            input = scanner.nextLine();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            scanner.close();
        }
        

        return input;
    }

    public static String[] makeData(String input) {
        int dataLenght = 4;
        String[] result = input.split(" ");
        if (result.length > dataLenght) {
            throw new MoreDataExeption();
        }
        if (result.length < dataLenght) {
            throw new LessDataExeption();
        }
        return result;
    }

    public static String[] checkFIO(Main[] result) {

        int dataLenght = 3;
        String[] fio = result[0].strip().split(",");
        if (fio.length != dataLenght) {
            throw new IncorrectFIOException();
        }
        return fio;
    }

    private String strip() {
        return null;
    }

    public static void checkBirthdate(String[] result) throws DateTimeParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        LocalDate ld = LocalDate.parse(result[1], formatter);

    }

    public static void checkNumber(String[] result) throws NumberFormatException {

        Integer.parseInt(result[2]);
    }

    public static void checkGender(String[] result) {
        if (!result[3].equals("f") && !result[3].equals("m")) {
            throw new IncorrectGenderException();
        }
    }

    public static String fromArrayToString(String[] result) {
        StringBuilder sb = new StringBuilder();
        for (String s : result) {
            sb.append(s + " ");
        }
        return sb.toString();
    }

    public static void writeData(String[] result) {
        String fileName = checkFIO(result)[0];
        String forWrite = fromArrayToString(result);
        try (FileWriter writer = new FileWriter(String.format("Homework3/%s.txt", fileName), true)) {
            writer.append(forWrite);
            writer.append("\n");
            System.out.println("\nВведенные данные корректны и записаны в файл:)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] checkFIO(String[] result) {
        return null;
    }

}
