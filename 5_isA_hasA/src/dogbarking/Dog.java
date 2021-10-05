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
 * @file Dog.java
 * 강아지 클래스
 * 전략 객체를 유지하기 위한 멤버 변수를 추가해야 하며,
 * 이 객체를 설정하기 위한 
 * void setBarkStrategy(BarkStrategy barkStrategy)를
 * 추가해야 하고, bark 메소드는 이 전략을 사용하도록 수정해야 함
 */
public class Dog implements BarkStrategy {
	private String name;
	private BarkStrategy barkStrategy;

	public Dog(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBarkStrategy(BarkStrategy barkStrategy) {
		this.barkStrategy = barkStrategy;
	}

	public void bark() {
		// bark 메소드를 직접 정의하지 않고 인터페이스를 통해 수행되도록 작성.
		//System.out.printf("%s: 멍멍%n", name);

		barkStrategy.bark();
	}
}
