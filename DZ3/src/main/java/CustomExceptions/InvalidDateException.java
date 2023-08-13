package CustomExceptions;

public class InvalidDateException extends InvalidDataElementException{
    public InvalidDateException(String inputString){
        super("Отсутствует корректная дата в строке\n"+"'"+inputString+"'");
    }
}
