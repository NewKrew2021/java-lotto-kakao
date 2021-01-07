package lotto;

public enum LottoRank {
    FIRST(2000000000, 0, "6개 일치 "), SECOND(30000000, 1, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, 2, "5개 일치 "), FOURTH(50000, 3, "4개 일치 "),
    FIFTH(5000, 4, "3개 일치 "), NONE(0, 5, "");

    private int money;
    private int index;
    private String matchedPhrase;

    LottoRank(int money, int index, String matchedPhrase){
        this.money=money;
        this.index = index;
        this.matchedPhrase = matchedPhrase;
    }

    public int getMoney(){
        return money;
    }

    public int getIndex(){
        return index;
    }

    public String getMatchedPhrase() { return matchedPhrase; }

}
