# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 기능구현 목록
1. 구입 금액 입력
2. 총 구매 개수 결정 
3. 수동으로 구매할 로또 수 입력
4. 수동으로 구매할 로또 번호 입력 
5. 수동 및 자동으로 로또 생성 
    1) 입력 받은 수동 로또 번호로 LottoNumbers 객체들 생성 
    2) 6개 랜덤넘버 생성 및 LottoNumbers 생성 
    3) 수동 LottoNumbers와 자동 LottoNumbers로 LottoTickets 객체 생성 
6. 당첨번호 입력 및 예외처리
7. 보너스볼 입력 및 예외처리
8. 당첨 통계
9. 수익률 계산