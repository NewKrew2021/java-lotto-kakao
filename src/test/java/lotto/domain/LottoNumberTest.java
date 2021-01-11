package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalid_범위(int value) {
        assertThatThrownBy(() -> new LottoNumber(value)).isInstanceOf(IllegalArgumentException.class);
    }

}
