import controller.LottoProgram;

public class MainApplication {

    public static void main(String[] args) {
        try{
            new LottoProgram().start();
        } catch (Exception e){
            StringBuilder errorBuilder = new StringBuilder();
            errorBuilder.append("오류 원인 : ");
            errorBuilder.append(e.getMessage());
            System.out.println(errorBuilder.toString());
        }
    }
}
