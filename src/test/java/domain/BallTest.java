package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    void validator(){
        assertThatThrownBy(() -> {
            new Ball(46);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new Ball(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Ball("x");
        }).isInstanceOf(NumberFormatException.class);
    }
}
