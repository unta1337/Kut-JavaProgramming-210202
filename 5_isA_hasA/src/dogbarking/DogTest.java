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
 * @file DogTest.java
 * 테스트 프로그램
 */
public class DogTest {
	
	public static void main(String[] args) {
		Dog mimi = new Dog("미미");
		mimi.setBarkStrategy(new WalStrategy());
		mimi.bark();
		Dog general = new Dog("장군");
		general.setBarkStrategy(new MeongStrategy());
		general.bark();		
		general.setBarkStrategy(new WalStrategy());
		general.bark();		
	}

}
