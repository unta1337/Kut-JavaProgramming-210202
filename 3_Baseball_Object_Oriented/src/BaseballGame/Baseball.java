// 2020136018 김성녕

package BaseballGame;

import java.util.Scanner;
import java.util.regex.Pattern;			// 사용자 입력에서 Y/N을 구분하기 위해 정규식 사용.

// 사용자가 실제로 사용할 사용자와 play 함수를 제외한 모든 멤버 변수, 함수, 클래스들을 private으로 선언.
// System.in을 사용하는 Scanner 때문에 생성자를 이용해 외부의 Scanner를 불러와 사용.
public class Baseball {
	// Scanner와 N에 대한 정규식 표현은 변할 일이 없으므로 final로 선언.
	private final Scanner in;
	private final String noExpr = "(no|No|nO|NO|n|N)";
	
	private int[] bat;
	private int[] ball;
	private int result;
	private int out;
	
	public Baseball(Scanner in) {
		this.in = in;
		
		bat = new int[3];
		ball = new int[3];
		out = 0;
	}
	
	public void play() {
		do {
			playGame();
		} while (!done());
	}

	private void playGame() {
		GameLogics.pitch(ball);
		
		while (true) {
			System.out.print("[0-9]까지 숫자 3개를 입력하시오: ");
			for (int i = 0; i < 3; i++) {
				bat[i] = in.nextInt();
			}
			result = GameLogics.compare(ball, bat);
			
			if (result == 1) {
				System.out.println("사용자 승");
				break;
			} else if (result == -1) {
				++out;
				System.out.printf("OUT: %d\n", out);
				
				if (out == 3) {
					System.out.println("컴퓨터 승");
					break;
				}
			}
		}
	}
	
	private boolean done() {
		System.out.println("새로운 게임을 플레이하시겠습니까? (Y/N)");
		String s = in.next();
		
		return Pattern.matches(noExpr, s);
	}
	
	private class GameLogics {
		private static void pitch(int[] ball) {
			int[] flag = new int[10];
			
			for (int i = 0; i < 3; i++) {
				while (true) {
					// ThreadLocalRandom을 import하여 난수 생성.
					//b = ThreadLocalRandom.current().nextInt(10);
					
					// Math를 이용한 난수 생성.
					// 라이브러리를 추가로 import할 필요가 없다.
					ball[i] = (int)(Math.random() * 10);

					if (flag[ball[i]] == 0) {
						flag[ball[i]] = 1;
						break;
					}
				}
			}
		}

		private static int compare(int[] ball, int[] bat) {
			int[] flag = new int[10];
			int scount = 0;
			int bcount = 0;
			
			for (int i = 0; i < 3; i++)
				flag[ball[i]] = 1;

			for (int i = 0; i < 3; i++) {
				if (ball[i] == bat[i])
					++scount;
				else if (flag[bat[i]] == 1)
					++bcount;
			}
			
			if (scount == 3)
				return 1;
			else if (scount == 0 && bcount == 0)
				return -1;
			else {
				System.out.printf("S: %d, B: %d\n", scount, bcount);
				return 0;
			}
		}
	}
}