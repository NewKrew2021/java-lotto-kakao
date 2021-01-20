package lotto.view;

import lotto.dto.BuyingListDto;
import lotto.domain.BuyingList;
import lotto.dto.LottoDto;
import lotto.exception.WrongMoneyInputException;
import lotto.util.Validation;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final String WINNING_LOTTO_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MANUAL_LOTTO_INPUT_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_PRICE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INVALID_BONUS_BALL_NUMBER = "보너스볼 번호가 적절하지 않습니다.";
    private static final String WRONG_NUMBER = "잘못된 수를 입력하셨습니다.";
    private static Scanner sc = new Scanner(System.in);


    public void inputMoney(BuyingListDto buyingListDto) {
        String money;

        do {
            System.out.println(INPUT_PRICE);
            money = sc.nextLine();
        } while(!validateMoney(money));

        buyingListDto.setMoney(Integer.parseInt(money));
    }

    private static boolean validateMoney(String inputMoney) {
        int money = convertStringToInt(inputMoney);
        if( !BuyingList.validateInputMoney(money) ) {
            System.out.println(WrongMoneyInputException.WRONG_MONEY_INPUT_EXCEPTION);
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

    public void inputWinningLottoNumbers(LottoDto lottoDto) {
        lottoDto.setWinningLottoOnlyNumbers(inputLottoNumbers(WINNING_LOTTO_INPUT_TEXT));
    }

    public void inputManualLottoNumbers(BuyingListDto buyingListDto) {
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < buyingListDto.getManualTicketCount(); i++) {
            manualLottoNumbers.add(inputLottoNumbers(MANUAL_LOTTO_INPUT_TEXT));
        }
        buyingListDto.setManualLottoNumbers(manualLottoNumbers);
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
            System.out.println(Validation.INVALID_LOTTO_NUMBER);
            return false;
        }

        return true;
    }

    public void inputBonusNumber(LottoDto lottoDto) {
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

    public void inputManualLottoBuying(BuyingListDto buyingListDto) {
        String count;
        System.out.println(MANUAL_LOTTO_INPUT_TEXT);
        do {
            count = sc.nextLine();
        }while(!validateManualCount(count));

        buyingListDto.setManualTicketCount(Integer.parseInt(count));
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
