// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 5 주차
// 과제명: 상속과 포함관계, 인터페이스를 활용한 전략 패턴.
// 저자: 2020136018 김성녕

package dogbarking;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * @file BarkStrategy.java
 * 짖기 전략 interface
 */
public interface BarkStrategy {
	void bark();		// 함수 이름이 DogTest에서 bark이기 때문에 doBark에서 bark로 이름 변경함.
}