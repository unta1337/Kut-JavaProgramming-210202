// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 5 주차
// 과제명: 상속과 포함관계, 인터페이스를 활용한 전략 패턴.
// 저자: 2020136018 김성녕

package dogbarking;

public class MeongStrategy implements BarkStrategy {
	public void bark() {
		System.out.println("멍멍");
	}
}