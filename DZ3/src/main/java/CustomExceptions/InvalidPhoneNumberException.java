package CustomExceptions;

public class InvalidPhoneNumberException extends InvalidDataElementException{
    public InvalidPhoneNumberException(String inputString){
        super("Отсутствует корректный номер телефона в строке\n"+"'"+inputString+"'");
    }
}
