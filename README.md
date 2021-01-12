# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능 명세

### 로또 번호 구현
1. 로또 번호 객체 구현
2. 생성자에서 유효성 검사, 예외처리
   1. 1~45 사이인지
3. 객체 비교연산자

### 로또 번호 세트
1. 일급 콜렉션 
    1. 로또 번호를 List
2. 생성자에서 유효성 검사, 예외처리
    1. 갯수 검사
    2. 중복 검사
3. 객체 비교( 로또 번호 갯수 비교 )

### 당첨 로또 번호 세트
1. 일급 콜렉션 
    1. 로또 번호 세트
    2. 보너스볼 로또 번호
2. 생성자에서 유효성 검사, 예외처리
    1. 갯수 검사
    2. 중복 검사

### 로또 로직 클래스
1. 입력받은 횟수만큼 로또 갯수 생성
    1. 랜덤 로또 번호 추출 (collections.shuffle())
2. 로또 번호세트와 당첨 로또 번호 세트를 비교
    1. 로또 번호 세트 끼리 비교
    2. 보너스 볼 비교 ( 당첨 갯수가 5개일 때 )
3. 당첨 통계 리턴
    1. 로또 번호 세트 일치 갯수
    2. 보너스 볼 일치 유무 ( 당첨 갯수가 5개일 때 )

### View 구현
1. Input Output

## File 목록
### domain
- LottoNo : 로또 번호 객체
- LottoTicket : 로또 티켓 객체
- Money : Input 돈 객체
- StatisticsResult : 매칭 결과 객체
- WinningLottoTicket : 당첨 로또 티켓 객체
- LottoLogic : 로또 구입, 당첨로또와 매칭

### view
- LottoInputView : Input UI view
- LottoOutputView : Output UI view

### 기타
- StatisticsType : 로또 당첨 Ranking enum
- LottoGameMain : main 함수
