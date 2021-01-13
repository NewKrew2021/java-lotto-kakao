package lotto.input;

import java.util.Scanner;

public abstract class ValidInputGuaranteer <T>{
    protected Scanner scanner = new Scanner(System.in);

    public T getFromUser(){
        if(!getComment().equals(""))
            System.out.println(getComment());
        try{
            String valueFromUser = scanner.nextLine();
            return transformToObject(valueFromUser);
        } catch (Exception e){
            System.out.println("적절하지 않은 입력 입니다.");
            return getFromUser();
        }
    }

    abstract String getComment();

    public abstract T transformToObject(String input);
}
