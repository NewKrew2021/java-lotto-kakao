package lotto.domain.ranking;

import lotto.domain.game.LottoRevenueRate;
import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static lotto.domain.game.LottoTicketCount.UNIT_OF_MONEY;

public class LottoStatistics {

    private static final long DEFAULT_COUNT = 0L;
    private static final Long INITIAL_TOTAL_PRICE = 0L;
    private static final long INITIAL_TOTAL_COUNT = 0L;

    private final Map<LottoRanking, Long> rankingCount;

    private LottoStatistics(Map<LottoRanking, Long> rankingCount) {
        this.rankingCount = Collections.unmodifiableMap(rankingCount);
    }

    public static LottoStatistics of(List<LottoNumbers> lottoTickets, WinnerTicket winnerTicket) {
        Map<LottoRanking, Long> rankingCount = findRankingCount(lottoTickets, winnerTicket);
        fillDefaultCount(rankingCount);
        return new LottoStatistics(rankingCount);
    }

    private static Map<LottoRanking, Long> findRankingCount(List<LottoNumbers> lottoTickets, WinnerTicket winnerTicket) {
        return lottoTickets.stream()
                .map(ticket -> findRanking(winnerTicket, ticket))
                .collect(groupingBy(Function.identity(), () -> new EnumMap<>(LottoRanking.class), counting()));
    }

    private static LottoRanking findRanking(WinnerTicket winnerTicket, LottoNumbers ticket) {
        return LottoRanking.find(winnerTicket.countMatchingNumber(ticket), winnerTicket.hasBonus(ticket));
    }

    private static void fillDefaultCount(Map<LottoRanking, Long> rankingCount) {
        for (LottoRanking ranking : LottoRanking.values()) {
            rankingCount.putIfAbsent(ranking, DEFAULT_COUNT);
        }
    }

    public LottoRevenueRate calculateRevenueRate() {
        return LottoRevenueRate.of(calculateTotalPrice(), countTicket() * UNIT_OF_MONEY);
    }

    private long calculateTotalPrice() {
        long totalPrice = INITIAL_TOTAL_PRICE;
        for (Map.Entry<LottoRanking, Long> entry : rankingCount.entrySet()) {
            LottoRanking ranking = entry.getKey();
            Long count = entry.getValue();
            totalPrice += ranking.calculatePriceByMultiply(count);
        }
        return totalPrice;
    }

    private long countTicket() {
        return rankingCount.values().stream()
                .reduce(INITIAL_TOTAL_COUNT, Long::sum);
    }

    public Map<LottoRanking, Long> getRankingCount() {
        return rankingCount;
    }
}
