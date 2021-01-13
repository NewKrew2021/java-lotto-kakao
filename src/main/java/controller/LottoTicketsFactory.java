package controller;

import domain.LottoRandomGenerator;
import domain.LottoTickets;
import dto.LottoTicketCount;

import java.util.List;

public class LottoTicketsFactory {


    public static LottoTickets newManualAndAuto(LottoTicketCount ticketCount, List<List<Integer>> inputLottoNumbers) {
        LottoTickets manualTickets = LottoTickets.from(inputLottoNumbers);
        LottoTickets autoTickets = LottoTickets.of(new LottoRandomGenerator(), ticketCount.getRemainTicketCount());

        return manualTickets.concat(autoTickets);
    }
}
