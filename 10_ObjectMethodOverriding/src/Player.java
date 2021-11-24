// 2020136018 김성녕

import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * Player: 축구 선수 추상 클래스
 * 요구사항. toString, hashCode, equals, clone, compareTo 재정의
 * equals와 hashcode는 항상 모든 멤버 변수를 이용하여 비교/계산함
 * team 멤버는 깊은 복사가 필요하다고 가정함
 * toString은 각자 알아서
 * compareTo는 name을 이용하여 먼저 비교하고, 그다음 number를 이용하여 비교
 */
public abstract class Player implements Comparable {
	private String name;
	private int number;
	private Team team;

	public Player(String name, int number, Team team){
		setName(name);
		setNumber(number);
		this.team = Objects.requireNonNull(team);;
	}

	public String name() {
		return name;
	}

	public int number() {
		return number;
	}

	public Team team() {
		return team.clone();
	}

	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}

	public void setNumber(int number) {
		if(number<0) throw new IllegalArgumentException("");
		this.number = number;
	}

	@Override
	public String toString() {
		String term1 = String.format("Player::toString()%n");
		String term2 = String.format("Name: %d%n", number);
		String term3 = String.format("Team Info:%n%s%n", team.toString());

		return term1 + term2 + term3;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;
		
		Player other = (Player)o;

		boolean condition1 = name.equals(other.name);
		boolean condition2 = number == other.number;
		boolean condition3 = team.equals(other.team);

		return condition1 && condition2 && condition3;
	}

	@Override
	public int hashCode() {
		int hash = team.hashCode();

		for (int i = 0;  i < name.length(); i++)
			hash += (int)name.charAt(i);
		hash *= number;
		hash %= 1000000;

		return hash;
	}

	@Override
	public Player clone() throws CloneNotSupportedException {
		return (Player)super.clone();
	}

	@Override
	public int compareTo(Object o) {
		Player other = (Player)o;

		int compare1 = name.compareTo(other.name);
		if (compare1 != 0)
			return compare1;

		int compare2 = 0;
		compare2 = number < other.number ? -1 : 1;
		return compare2;
	}
}
