# 로또
## 진행 방법
* 로또을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


# 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

# 기능 목록
* 입력 View
    * 구입 금액 입력
        * 금액은 1000이상의 정수만 받으며, 1000으로 나누어떨어지는 만큼만 사용한다
    * 지난 주 당첨번호 입력
        * 번호는 1~45 범위의 정수만 허용하며, 중복이 없어야 한다.
    * 보너스 볼 입력
        * 번호는 1~45 범위의 정수만 허용하며, 당첨번호와 중복되면 안된다.
* 출력 View
    * 구입한 금액 출력
    * 로또 티켓 정보 출력
    * 당첨 통계 출력
    * 수익률 출력
* 로또 티켓 생성
    * 중복없는 랜덤 수 6개로 로또 번호 부여
    * 금액에 맞는만큼 로또 티켓 생성
* 당첨 확인
    * 당첨번호와 로또번호를 비교하여 일치하는 수 반환(보너스 볼 포함 여부도 확인)
    * 총 당첨 금액 합산
    * 금액 대비 당첨금액으로 수익 계산
