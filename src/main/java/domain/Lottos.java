package domain;

import utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Lotto> lottos;

    public Lottos() {
        this(new ArrayList<>());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void generateManualLottos(List<String> inputs) {
        inputs.stream()
                .map(StringUtils::splitText)
                .forEach(lotto -> lottos.add(new Lotto(generateManualLotto(lotto))));
    }

    private List<Integer> generateManualLotto(List<String> lottos) {
        return lottos.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public void generateAutoLottos(int autoLottoCount) {
        IntStream.range(0, autoLottoCount)
                .forEach(i -> lottos.add(new Lotto(generateAutoLotto())));
    }

    private List<Integer> generateAutoLotto() {
        List<String> lottoString = IntStream
                .rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
                .boxed()
                .map(number -> Integer.toString(number))
                .collect(Collectors.toList());

        Collections.shuffle(lottoString);
        return lottoString.stream()
                .limit(LOTTO_NUMBER_SIZE)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos) {
            stringBuilder.append(lotto).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
