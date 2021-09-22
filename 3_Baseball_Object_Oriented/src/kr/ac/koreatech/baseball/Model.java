package kr.ac.koreatech.baseball;

public class Model {
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
