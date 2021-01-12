package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateTicket {
    public static List<LottoTicket> createAutoTicket(int price){
        return IntStream.range(1, price / 1000 + 1)
                .mapToObj(val -> new LottoTicket(new HashSet<>(new LottoNumber().getRandomNumbers())))
                .collect(Collectors.toList());
    }

}
