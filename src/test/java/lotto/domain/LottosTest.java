package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void testGetSize() {
        Lottos lottos = Lottos.getInstance(3);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    void testMerge() {
        Lottos lottos = new Lottos(new String[] {
                "1, 2, 3, 4, 5, 6",
                "2, 4, 6, 8, 10, 12",
                "5, 10, 15, 20, 25, 30"
        });
        lottos = lottos.merge(new Lottos(new String[] {
                "30, 31, 32, 33, 34, 35",
                "37, 39, 41, 42, 43, 44",
                "39, 40, 41, 42, 44, 45"
        }));

        assertThat(lottos).isEqualTo(new Lottos(new String[] {
                "1, 2, 3, 4, 5, 6",
                "2, 4, 6, 8, 10, 12",
                "5, 10, 15, 20, 25, 30",
                "30, 31, 32, 33, 34, 35",
                "37, 39, 41, 42, 43, 44",
                "39, 40, 41, 42, 44, 45"
        }));
    }
}
