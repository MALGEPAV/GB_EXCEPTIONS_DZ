package CustomExceptions;

public class InvalidGenderException extends InvalidDataElementException{
    public InvalidGenderException(String inputString){
        super("Отсутствует корректный пол в строке\n"+"'"+inputString+"'");
    }
}
