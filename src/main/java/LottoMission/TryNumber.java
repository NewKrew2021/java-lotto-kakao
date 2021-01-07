package LottoMission;

public class TryNumber {

    private int tryNumber;

    public TryNumber(int tryNumber) {
        if(isNegativeNumber(tryNumber)){
            throw new IllegalArgumentException("시행 횟수는 음수가 될 수 없습니다.");
        }
        this.tryNumber = tryNumber;
    }

    public boolean isNegativeNumber(int number){
        return number < 0;
    }

    public void useTryNumberCount(){
        this.tryNumber -= 1;
    }

    public boolean canTry(){
        return tryNumber >= 1;
    }

}
