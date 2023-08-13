package CustomExceptions;

public class InvalidDataElementException extends RuntimeException{
    public InvalidDataElementException(String message){
        super(message);
    }
}
