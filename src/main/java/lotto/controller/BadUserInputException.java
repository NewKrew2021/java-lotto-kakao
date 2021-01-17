package lotto.controller;

public class BadUserInputException extends RuntimeException{

    public BadUserInputException(String message){
        super(message);
    }
}
