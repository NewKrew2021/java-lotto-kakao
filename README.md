# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

##구현 클래스
* controller
  * LottoGame : 로또 게임의 동작을 관리하는 컨트롤러
    
* domain
  * LottoRank : 로또 등수에 대한 enum 클래스
  * LottoResults : 구입한 로또들에 대한 등수 결과 클래스
  * LottoTicket : 로또 한 장에 대한 클래스
  * LottoTickets : 구입한 로또 여러 장에 대한 클래스
  * MatchResult : 로또 결과를 비교하기 위한 클래스
  * Number : 로또 번호 하나에 대한 클래스
  * NumberPool : 로또 번호들을 캐싱해놓은 클래스
  * Price : 유저로부터 입력받는 금액을 저장하는 클래  
  * RankTable : 일치한 번호 갯수, 보너스 일치 여부로 등수를 판단하기 위한 클래스
  * WinnerNumber : 정답 번호를 저장하는 클래스로 LottoTicket을 상속
* util
  * StringUtility : String을 가공하기 위한 클래스
* view
  * LottoGameView : 입, 출력을 담당하는 클래스