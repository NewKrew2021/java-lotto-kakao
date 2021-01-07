# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 요구사항
로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.  
로또 1장의 가격은 1000원이다.  

### 기능 구현 계획 사항
#### 도메인 영역
- [x] 0 로또 번호를 랩핑하는 LotteryNumber class 구현
  - [x] 0.1 로또 번호 유효성 검사 기능 구현
- [x] 1 로또 한 장을 랩핑하는 Lottery class 구현
  - [x] 1.1 (구현 취소) 수동, 자동으로 구매 선택 기능 하도록 Strategy interface 구현
  - [x] 1.2 선택한 방법에 따라 로또 한 장을 발급
    - [x] 1.2.1 자동으로 발급 시, 6개의 숫자를 랜덤하게 발권
    - [x] 1.2.2 수동으로 발급 시, 6개의 숫자를 입력받아 그대로 발권
      - [x] 1.2.2.1 유효한 숫자 범위가 아닌 경우 예외 발생
  - [x] 1.3 당첨 번호를 입력 시, 맞은 개수 혹은 등수를 반환하는 기능 구현
- [x] 2 로또 여러 장을 랩핑하는 Lotteries class 구현
  - [x] 2.1 당첨 번호를 입력 시, 맞은 개수 혹은 등수를 정렬해서 반환하는 기능 구현
- [x] 3 LotteryUtil class 구현 및 구입 금액에서 몇 장의 로또인지 체크하는 기능 구현
- [x] 4 (구현 추가) LotteryAnswer class 구현 및 당첨 계산 로직 간결화

#### UI 영역
- [x] 1 입력 UI 처리 클래스 InputView class
  - [x] 1.1 구입금액 입력받는 UI 구현
  - [x] 1.2 지난 주 당첨 번호, 보너스 볼 입력 UI 구현
- [x] 2 출력 UI 처리 클래스 OutputView class
  - [x] 2.1 구매 개수 출력 UI 구현
  - [x] 2.2 1개의 Lottery 로부터 발행된 로또 숫자들을 출력 UI 구현
  - [x] 2.3 Lotteries 로부터 발행된 로또들의 숫자들을 출력 UI 구현
  - [x] 2.4 Lotteries 로부터 통계와 총 수익률 출력 UI 구현
- [x] 3 로또 복권 흐름 진행하는 main 구현

## 실행 예시
```
로또 1장의 가격은 1000원이다.  
구입금액을 입력해 주세요.  
14000  
14개를 구매했습니다.  
[8, 21, 23, 41, 42, 43]  
[3, 5, 11, 16, 32, 38]  
[7, 11, 16, 35, 36, 44]  
[1, 8, 11, 31, 41, 42]  
[13, 14, 16, 38, 42, 45]  
[7, 11, 30, 40, 42, 43]  
[2, 13, 22, 32, 38, 45]  
[23, 25, 33, 36, 39, 41]  
[1, 3, 5, 14, 22, 45]  
[5, 9, 38, 41, 43, 44]  
[2, 8, 9, 18, 19, 21]  
[13, 14, 18, 21, 23, 35]  
[17, 21, 29, 37, 42, 45]  
[3, 8, 27, 30, 35, 44]  

지난 주 당첨 번호를 입력해 주세요.  
1, 2, 3, 4, 5, 6  
보너스 볼을 입력해 주세요.  
7  

당첨 통계
---------
3개 일치 (5000원)- 1개  
4개 일치 (50000원)- 0개  
5개 일치 (1500000원)- 0개  
5개 일치, 보너스 볼 일치(30000000원) - 0개  
6개 일치 (2000000000원)- 0개  
총 수익률은 30%입니다.  
```

## 프로그래밍 요구사항
- indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- else를 사용하지 마라.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 ArrayList를 사용한다.
- java enum을 적용해 프로그래밍을 구현한다.
- 규칙 3: 모든 원시값과 문자열을 포장한다.
- 규칙 5: 줄여쓰지 않는다(축약 금지).
- 규칙 8: 일급 콜렉션을 쓴다.

## 힌트
- 로또 자동 생성은 Collections.shuffle() 메소드 활용한다.
- Collections.sort() 메소드를 활용해 정렬 가능하다.
- ArrayList의 contains() 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.

