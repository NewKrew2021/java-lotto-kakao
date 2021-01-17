package lotto.view;

import lotto.domain.LottoDto;
import lotto.domain.PurchaseList;
import lotto.util.Validation;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final String WINNING_LOTTO_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MANUAL_LOTTO_INPUT_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_PRICE = "구입 금액을 입력해 주세요.";
    private static final String WRONG_PRICE = "잘못된 금액을 입력하셨습니다.";
    private static final String INVALID_LOTTO_NUMBER = "로또 번호가 적절하지 않습니다.";
    private static final String INPUT_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INVALID_BONUS_BALL_NUMBER = "보너스볼 번호가 적절하지 않습니다.";
    private static final String WRONG_NUMBER = "잘못된 수를 입력하셨습니다.";
    private static Scanner sc = new Scanner(System.in);

    private LottoDto lottoDto;

    public LottoInputView(LottoDto lottoDto) {
        this.lottoDto = lottoDto;
    }

    public void inputMoney() {
        String money;

        do {
            System.out.println(INPUT_PRICE);
            money = sc.nextLine();
        } while(!validateMoney(money));

        this.lottoDto.setMoney(Integer.parseInt(money));
    }

    private static boolean validateMoney(String inputMoney) {
        int money = convertStringToInt(inputMoney);
        if( !PurchaseList.validateInputMoney(money) ) {
            System.out.println(WRONG_PRICE);
            return false;
        }
        return true;
    }

    private static Integer convertStringToInt(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void inputWinningLottoNumbers() {
        lottoDto.setWinningLottoOnlyNumbers(inputLottoNumbers(WINNING_LOTTO_INPUT_TEXT));
    }

    public void inputManualLottoNumbers() {
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoDto.getManualTicketCount(); i++) {
            manualLottoNumbers.add(inputLottoNumbers(MANUAL_LOTTO_INPUT_TEXT));
        }
        lottoDto.setManualLottoNumbers(manualLottoNumbers);
    }

    private Set<Integer> inputLottoNumbers(String printText) {
        Set<Integer> nums;
        do{
            System.out.println(printText);
            nums = convertInputToNumbers(sc.nextLine().split(", "));
        }while(!validateWinningNumber(nums));
        return nums;
    }

    private static Set<Integer> convertInputToNumbers(String[] inputString) {
        try {
            return Arrays.stream(inputString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new HashSet<>();
    }

    private static boolean validateWinningNumber(Set<Integer> numbers){
        if( !Validation.validateLottoTicket(numbers) ) {
            System.out.println(INVALID_LOTTO_NUMBER);
            return false;
        }

        return true;
    }

    public void inputBonusNumber() {
        String bonusNum;
        do{
            System.out.println(INPUT_BONUS_BALL_NUMBER);
            bonusNum = sc.nextLine();
        }while(!validateBonusNumber(bonusNum));
        System.out.println();
        lottoDto.setBonusNumber(Integer.parseInt(bonusNum));
    }

    private static boolean validateBonusNumber(String inputBonus){
        int bonusNum = convertStringToInt(inputBonus);
        if( !Validation.validateLottoNo(bonusNum) ) {
            System.out.println(INVALID_BONUS_BALL_NUMBER);
            return false;
        }

        return true;
    }

    public void inputManualLottoBuying() {
        String count;
        System.out.println(MANUAL_LOTTO_INPUT_TEXT);
        do {
            count = sc.nextLine();
        }while(!validateManualCount(count));

        lottoDto.setManualTicketCount(Integer.parseInt(count));
    }

    private static boolean validateManualCount(String inputCount) {
        int count = convertStringToInt(inputCount);
        if( count < 0 ) {
            System.out.println(WRONG_NUMBER);
            return false;
        }
        return true;
    }

}
