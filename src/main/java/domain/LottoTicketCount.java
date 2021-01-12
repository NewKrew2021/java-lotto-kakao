package domain;


import domain.exceptions.InvalidLottoTicketCountException;

import java.util.Objects;

public class LottoTicketCount {

    private final int lottoTicketCount;

    public LottoTicketCount(int lottoTicketCount, int totalTicketCount) {
        validate(lottoTicketCount, totalTicketCount);
        this.lottoTicketCount = lottoTicketCount;
    }

    private void validate(int lottoTicketCount, int totalTicketCount) {
        if(lottoTicketCount > totalTicketCount) {
            throw new InvalidLottoTicketCountException("구입 개수가 총 구입 개수보다 클 수 없습니다.");
        }
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicketCount that = (LottoTicketCount) o;
        return lottoTicketCount == that.lottoTicketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicketCount);
    }
}
