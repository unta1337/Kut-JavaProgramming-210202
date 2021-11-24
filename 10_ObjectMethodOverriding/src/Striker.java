//2020136018 김셩녕

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * Strike: 공격수
 * 부모 클래스: Player
 * 요구사항. toString, hashCode, equals, clone, comparTo 재정의
 * toString은 기본적으로 부모의 toString을 활용하는 형태로 각자 알아서
 * compareTo는 부모에 정의된 메소드를 먼저 이용하고, 동일하면 goal을 이용하여 비교
 */
public final class Striker extends Player {
	private int goal = 0;
	private int assist = 0; 

	public Striker(String name, int number, Team team) {
		super(name, number, team);
	}

	public int goal() {
		return goal;
	}

	public int assist() {
		return assist;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public void setAssist(int assist) {
		this.assist = assist;
	}

	@Override
	public String toString() {
		String term1 = "Goal: " + goal + "\n";
		String term2 = "assist: " + assist + "\n";
		String term3 = "Player Info: \n" + super.toString();

		return term1 + term2 + term3;
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;

		Striker other = (Striker)o;

		boolean superCondition = super.equals(other);
		boolean condition1 = goal == other.goal;
		boolean condition2 = assist == other.assist;

		return superCondition && condition1 && condition2;
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();

		hash *= goal;
		hash += assist;
		hash %= 1000000;

		return hash;
	}

	@Override
	public Player clone() {
		Striker newStriker =  new Striker(name(), number(), team());
		newStriker.setGoal(goal);
		newStriker.setAssist(assist);

		return (Player)newStriker;
	}

	@Override
	public int compareTo(Object o) {
		int superCompare = super.compareTo(o);

		Striker other = (Striker)o;

		if (superCompare != 0)
			return superCompare;

		int compare = 0;
		compare = goal < other.goal ? -1 : 1;
		return compare;
	}
}
