package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateTicket {
    public static List<LottoTicket> createTotalTicket(int price, List<String> handTicket){
        if(price/1000 < handTicket.size()){
            throw new InvalidHandTicketSizeException();
        }
        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.addAll(createAutoTicket(price - handTicket.size()*1000));
        lottoTickets.addAll(createHandTicket(handTicket));

        return lottoTickets;
    }

    private static List<LottoTicket> createAutoTicket(int price){
        return IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(new LottoNumber().getRandomNumbers())))
                .collect(Collectors.toList());
    }

    private static List<LottoTicket> createHandTicket(List<String> handTicket) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String ticket : handTicket) {
            lottoTickets.add(new LottoTicket(changeValidNumber(ticket)));
        }
        return lottoTickets;
    }

    private static Set<Number> changeValidNumber(String ticket){
        return Arrays.stream(ticket
                .replaceAll(" ", "")
                .split(","))
                .map(Integer::valueOf)
                .map(Number::new)
                .collect(Collectors.toSet());
    }
}
