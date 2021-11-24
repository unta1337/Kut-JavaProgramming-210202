// 2020136018 김성녕

import java.util.Objects;

/**
 * @copyright 한국기술교육대학교 컴퓨터공학부 자바프로그래밍
 * @version 2021년도 2학기
 * @author 김상진 
 * Team: 축구 구단 정보
 * 요구사항. toString, hashCode, equals, clone 재정의
 * toString은 각자 알아서
 */
public final class Team {
	private String name;
	private String country;
	public int currentLeaguePos = 0;  // 비시즌에서는 0

	public Team(String name, String country) {
		this.name = Objects.requireNonNull(name);
		this.country = Objects.requireNonNull(country);
	}

	public String name() {
		return name;
	}

	public String country() {
		return country;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCurrentLeaguePos(int pos) {
		if(pos>=0) currentLeaguePos = pos;
	}

	@Override
	public String toString() {
		String term1 = "Team::toString()\n";
		String term2 = String.format("Name: %s\n", name);
		String term3 = String.format("Country: %s\n", country);
		String term4 = String.format("Current League Pos: %d\n", currentLeaguePos);
		String term5 = String.format("Hash Code: %d\n", hashCode());

		return term1 + term2 + term3 + term4 + term5;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass())
			return false;
		if (this == o)
			return true;

		Team other = (Team)o;

		boolean condition1 = name.equals(other.name());
		boolean condition2 = country.equals(other.country());
		boolean condition3 = currentLeaguePos == other.currentLeaguePos;

		return condition1 && condition2 && condition3;
	}

	@Override
	public int hashCode() {
		int hash = 0;

		for (int i = 0;  i < name.length(); i++)
			hash += (int)name.charAt(i);
		for (int i = 0;  i < country.length(); i++)
			hash += (int)country.charAt(i);
		hash %= 1000000;

		return hash;
	}

	@Override
	public Team clone() {
		Team team = new Team(name, country);
		team.currentLeaguePos = currentLeaguePos;

		return team;
	}
}
