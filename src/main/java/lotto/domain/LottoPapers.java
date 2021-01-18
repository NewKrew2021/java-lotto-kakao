package lotto.domain;

import lotto.exceptions.EmptyLottoPaperPrintedException;

import java.util.ArrayList;
import java.util.List;

public class LottoPapers {
    private List<LottoPaper> papers = new ArrayList<>();

    public void add(LottoPaper manualLottoPaper) {
        papers.add(manualLottoPaper);
    }

    public LottoPaper getMergedPaper() {
        validateWhetherLottoPapersIsEmpty();

        LottoPaper mergedPaper = papers.get(0);
        for(int i = 1; i < papers.size(); i++){
            mergedPaper = LottoPaper.join(mergedPaper, papers.get(i));
        }

        return mergedPaper;
    }

    private void validateWhetherLottoPapersIsEmpty() {
        if(papers.size() == 0){
            throw new EmptyLottoPaperPrintedException("비어있는 lottoPapers를 출력하였습니다.");
        }
    }
}
