package lotto.setting;

import lotto.domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FormatTest {

    @Test
    public void ticketSizeExceptionCheck(){
        Set<Integer> testNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    new Ticket(testNumbers);
                }).withMessageMatching("invalid Ticket size!!");
    }

    @Test
    public void invalidNumberCheck(){
        Set<Integer> testNumbers = new HashSet<>(Arrays.asList(0, 20, 30, 40, 43, 44));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    new Ticket(testNumbers);
                }).withMessageMatching("contains invalid number value.");
    }

    @Test
    public void bonusBallCheck(){
        Set<Integer> testNumbers = new HashSet<>(Arrays.asList(0, 20, 30, 40, 43, 44));
        int bonusBall = 20;

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    Format.validateBonusBall(testNumbers, bonusBall);
                }).withMessageMatching("bonusBall number already included.");
    }
}
