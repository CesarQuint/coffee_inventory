package czar.coffee.handler.coffee.handler.controllers.exceptions;

public class DuplicateNameException extends RuntimeException{

    public DuplicateNameException(String message){
        super(message);
    }

}
