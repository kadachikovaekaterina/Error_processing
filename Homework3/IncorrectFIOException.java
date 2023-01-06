package Homework3;

public class IncorrectFIOException extends RuntimeException  {

    public IncorrectFIOException() {
        super("Некорректно заполнено поле ФИО");
    }
    
}
