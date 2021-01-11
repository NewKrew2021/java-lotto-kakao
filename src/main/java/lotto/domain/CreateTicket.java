package lotto.domain;

        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.IntStream;

public class CreateTicket {
    private List<LottoTicket> lottoTickets;
    private LottoNumber lottoNumber;

    private CreateTicket(int price){
        lottoNumber = new LottoNumber();
        lottoTickets = new ArrayList<>();
        lottoTickets = IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(lottoNumber.getRandomNumbers())))
                .collect(Collectors.toList());
    }

    public static LottoTickets createAutoTicket(int price){
        CreateTicket createTicket = new CreateTicket(price);
        return new LottoTickets(createTicket.getTickets());
    }

    public List<LottoTicket> getTickets(){
        return lottoTickets;
    }
}
