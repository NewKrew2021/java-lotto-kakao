package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

  private static final List<Integer> randomNumbers;

  static {
    randomNumbers = new ArrayList<>();
    for (int i = LottoNumber.LOWER_BOUND; i <= LottoNumber.UPPER_BOUND; i++) {
      randomNumbers.add(i);
    }
  }

  public static LottoTickets generateLottoTickets(List<String> manualLottoNumbers, int autoCount) {
    List<LottoTicket> lottoTickets = new ArrayList<>();
    lottoTickets.addAll(generateManualLottoTickets(manualLottoNumbers));
    lottoTickets.addAll(generateRandomLottoTickets(autoCount));

    return new LottoTickets(lottoTickets);
  }

  private static List<LottoTicket> generateManualLottoTickets(List<String> manualLottoNumbers) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (String manualLottoNumber : manualLottoNumbers) {
      tickets.add(LottoTicket.of(manualLottoNumber));
    }

    return tickets;
  }

  public static List<LottoTicket> generateRandomLottoTickets(int ticketCount) {
    List<LottoTicket> tickets = new ArrayList<>();
    for (int i = 0; i < ticketCount; i++) {
      tickets.add(generateRandomLottoTicket());
    }

    return tickets;
  }

  private static LottoTicket generateRandomLottoTicket() {
    Collections.shuffle(randomNumbers);
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < LottoTicket.LOTTO_NUMBERS_LENGTH; i++) {
      numbers.add((randomNumbers.get(i)));
    }
    Collections.sort(numbers);

    return LottoTicket.of(numbers);
  }
}
