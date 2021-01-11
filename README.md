# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 요구사항
* 기능 요구사항
  * 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  * 로또 1장의 가격은 1000원이다.
* 프로그래밍 요구사항  
  * java enum을 적용해 프로그래밍을 구현한다.
  * 모든 원시값과 문자열을 포장한다.
  * 줄여쓰지 않는다(축약 금지).
  * 일급 콜렉션을 쓴다. 
  * indent(인덴트, 들여쓰기) depth를 1단계까지만 한다.
  * else를 사용하지 마라.
  * 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  * method가 한 가지 일만 하도록 최대한 작게 만들어라.
  * 배열 대신 ArrayList를 사용한다.
  
## 구현 클래스
* controller
  * LottoGame : 로또 게임의 동작을 관리하는 컨트롤러
    
* domain
  * BallCountChecker : 입력받는 로또 번호 갯수를 체크하는 클래스
  * LottoRank : 로또 등수에 대한 enum 클래스
  * LottoResults : 구입한 로또들에 대한 등수 결과 클래스
  * LottoTicket : 로또 한 장에 대한 클래스
  * LottoTickets : 구입한 로또 여러 장에 대한 클래스
  * MatchResult : 로또 결과를 비교하기 위한 클래스
  * Number : 로또 번호 하나에 대한 클래스
  * NumberPool : 로또 번호들을 캐싱해놓은 클래스
  * Price : 유저로부터 입력받는 금액을 저장하는 클래스
  * WinnerNumber : 정답 번호를 저장하는 클래스

* view
  * LottoGameInputView : 사용자로부터 입력을 담당하는 클래스
  * LottoGameView : 출력 화면 및 문구를 담당하는 클래스
