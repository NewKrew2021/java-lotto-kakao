package lotto.domain.dto;

import java.util.List;

public class LottoTicketsDto {
    private final List<LottoNumbersDto> tickets;

    public LottoTicketsDto(List<LottoNumbersDto> tickets) {
        this.tickets = tickets;
    }

    public List<LottoNumbersDto> getTickets() {
        return tickets;
    }
}
