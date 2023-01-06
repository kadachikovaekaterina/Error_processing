package Homework3;

public class LessDataExeption extends RuntimeException {

    public LessDataExeption() {
        super("Введено меньше данных, чем нужно");
    }
    
}
