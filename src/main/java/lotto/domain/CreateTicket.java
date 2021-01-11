package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateTicket {
    private List<LottoTicket> lottoTickets;
    private LottoNumber lottoNumber;

    public CreateTicket(int price){
        lottoNumber = new LottoNumber();
        lottoTickets = new ArrayList<>();
        lottoTickets = IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(lottoNumber.getRandomNumbers())))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> allocateTicket(){
        return lottoTickets;
    }
}
