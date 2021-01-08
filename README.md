# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 진행 코드
* controller
    * 전체적으로 로직을 진행할 controller입니다.
* domain
    * 논리적으로 model과 동일합니다.
    * LottoRank
        * 로또와 관련해서 등급을 가진 열거형입니다.
    * LottoResults
        * 로또의 결과를 가지고 있는 클래스입니다.
    * LottoTicket
        * 로또 한장 티켓을 의미하는 클래스입니다.
    * LottoTickets
        * 로또 티켓 여러장을 가진 클래스입니다.
    * Number
        * 로또의 한자리 숫자를 의미하는 클래스입니다.
    * NumberPool
        * 로또의 숫자를 자동으로 생성하는 클래스입니다.
    * RankTable
        * 로또의 인자값을 받아서 Rank를 리턴하게 만드는 매핑 테이블 클래스입니다.
    * WinnerNumber
        * 로또티켓을 상속하며 보너스 볼을 가지는 클래스입니다.
* exception
    * 예외를 가지고 있는 패키지입니다.
* view
    * 화면에 출력하는 로직을 가진 패키지입니다.

## 요구사항
* indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
    * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
* else를 사용하지 마라.
* method의 크기가 최대 10라인을 넘지 않도록 구현한다.
    *method가 한 가지 일만 하도록 최대한 작게 만들어라.
* 배열 대신 ArrayList를 사용한다.
* java enum을 적용해 프로그래밍을 구현한다.
* 규칙 3: 모든 원시값과 문자열을 포장한다.
* 규칙 5: 줄여쓰지 않는다(축약 금지).
* 규칙 8: 일급 콜렉션을 쓴다.

