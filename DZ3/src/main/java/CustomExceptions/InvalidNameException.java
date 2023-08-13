package CustomExceptions;

public class InvalidNameException extends InvalidDataElementException{
    public InvalidNameException(String inputString){
        super("Отсутствуют корректные ФИО в строке\n"+"'"+inputString+"'");
    }
}
