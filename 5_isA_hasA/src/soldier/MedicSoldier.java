// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 5 주차
// 과제명: 상속과 포함관계, 인터페이스를 활용한 전략 패턴.
// 저자: 2020136018 김성녕

package soldier;

// useA 관계이므로 오버라이딩을 통한 함수 재정의는 할 수 없고, 모든 함수를 다시 써야 한다.
public class MedicSoldier {
	Soldier soldier;
	
	MedicSoldier() {
		soldier = new Soldier();
	}
	
	public int attack() {
		return soldier.attack();
	}
	
	public void defend(int hitPower) {
		soldier.defend(hitPower);
	}
	
	public void heal() {
		soldier.heal();
		soldier.heal();
	}
	
	public boolean isLive() {
		return soldier.isLive();
	}
	
	public int getHealth() {
		return soldier.getHealth();
	}
}

// isA 관계는 상속 관계로 부모 클래스에서 이미 정의한 변수나 메소드에 대해서 신경쓸 필요가 없고, 재정의가 필요한 것만 수정하면 된다.
// 반면에, hasA 관계는 상속 관계가 아니므로 이미 정의한 변수나 메소드에 대해서도 다시 정의해야 하는 추가적인 작업이 필요하다.
// 그러나, 다중 상속이 불가능한 자바에서 인터페이스가 아닌 방식으로 다중 상속을 어느 정도 흉내낼 수 있다는 장점이 있다.