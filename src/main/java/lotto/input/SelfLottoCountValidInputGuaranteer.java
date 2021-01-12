package lotto.input;

public class SelfLottoCountValidInputGuaranteer extends ValidInputGuaranteer<Integer>{
    @Override
    protected String getComment(){
        return "수동으로 구매할 로또 갯수를 입력해 주세요";
    }

    @Override
    public Integer transformToObject(String input){
        return Integer.parseInt(input);
    }
}
