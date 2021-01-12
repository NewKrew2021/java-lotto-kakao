package lotto.util;

public class StringUtils {
    public static boolean isBlank(String text){

        return text == null || text.isEmpty();
    }

    public static boolean isNumber(String text){
        try{
            Integer.parseInt(text);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
