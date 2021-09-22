// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 3 주차
// 과제명: 객체지향 패턴으로 숫자 야구 게임 작성하기
// 저자: 2020136018 김성녕

package kr.ac.koreatech.baseball;

public class Model {
	// 플레이어의 결과를 연산하기 위한 열거형.
	enum PlayerStatus {
		WIN,
		LOSE,
		DRAW
	}

	private int[] bats;
	private int[] balls;
	private PlayerStatus result;
	private int out;
	
	// 접근자.
	public int[] getBats() {
		return bats;
	}

	public int[] getBalls() {
		return balls;
	}
	
	public PlayerStatus getResult() {
		return result;
	}
	
	public int getOut() {
		return out;
	}

	// 수정자.
	public void setBats(int[] bats) {
		this.bats = bats;
	}

	public void setBalls(int[] balls) {
		this.balls = balls;
	}

	public void setResult(PlayerStatus result) {
		this.result = result;
	}

	public void setOut(int out) {
		this.out = out;
	}

	// 변수 처리.
	public void addOut() {
		out++;
	}

	// 게임 로직.
	// 최초 게임 설정 수행.
	void initBalls() {
		int[] flags = new int[10];
		
		for (int i = 0; i < 3; i++) {
			while (true) {
				balls[i] = (int)(Math.random() * 10);
				
				if (flags[balls[i]] == 0) {
					flags[balls[i]] = 1;
					break;
				}
			}
		}
	}
	
	int[] getStrikesAndBalls() {
		int[] flags = new int[10];
		int strikeCount = 0;
		int ballCount = 0;
		
		for (int i = 0; i < 3; i++)
			flags[balls[i]] = 1;
		for (int i = 0; i < 3; i++) {
			if (balls[i] == bats[i])
				strikeCount++;
			else if (flags[bats[i]] == 1)
				ballCount++;
		}
		
		return new int[] { strikeCount, ballCount };
	}
	
	PlayerStatus evalResult() {
		int[] strikesAndBalls = getStrikesAndBalls();
		
		if (strikesAndBalls[0] == 3)
			return PlayerStatus.WIN;
		else if (strikesAndBalls[0] == 0 && strikesAndBalls[1] == 0)
			return PlayerStatus.LOSE;
		else
			return PlayerStatus.DRAW;
	}
}
