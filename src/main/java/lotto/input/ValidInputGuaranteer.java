package lotto.input;

import java.util.Scanner;

public abstract class ValidInputGuaranteer <T>{
    protected Scanner scanner = new Scanner(System.in);

    public T getFromUser(){
        System.out.println(getComment());
        try{
            String valueFromUser = scanner.nextLine();
            return transformToObject(valueFromUser);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return getFromUser();
        }
    }

    abstract String getComment();

    public abstract T transformToObject(String input);
}
