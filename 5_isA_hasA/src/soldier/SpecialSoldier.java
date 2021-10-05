// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 5 주차
// 과제명: 상속과 포함관계, 인터페이스를 활용한 전략 패턴.
// 저자: 2020136018 김성녕

package soldier;

import java.util.concurrent.ThreadLocalRandom;

// isA 관계이므로 모든 변수 및 메소드를 재정의할 필요하 없고, 부모 클래스와 다르게 정의해야 하는 변수나 메소드만 오버라이딩하면 된다.
public class SpecialSoldier extends Soldier {
	@Override
	public int attack() {
		return ThreadLocalRandom.current().nextInt(3) + 2;			// 0-2 사이의 난수 + 2 = 2-4 사이의 난수.
	}
}