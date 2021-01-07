package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomGenerateStrategyTest {
    @DisplayName("랜덤 전략이 주어지면 만들어진 배열의 길이가 6이 맞는지 확인합니다.")
    @Test
    void create(){
        //given
        NumberGenerateStrategy strategy = new RandomGenerateStrategy();
        //when
        List<Integer> randomNumbers = strategy.generate();

        //then
        assertThat(randomNumbers.size()).isEqualTo(6);
    }
}