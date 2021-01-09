package lotto.input;

import java.util.Scanner;

public class ValidInputGuaranteer {
    protected Scanner scanner = new Scanner(System.in);

    public String getFromUser(){
        System.out.println(getComment());
        try{
            String valueFromUser = scanner.nextLine();
            checkValid(valueFromUser);
            return valueFromUser;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return getFromUser();
        }
    }

    protected String getComment(){
        return "";
    }

    protected void checkValid(String input){

    }
}
