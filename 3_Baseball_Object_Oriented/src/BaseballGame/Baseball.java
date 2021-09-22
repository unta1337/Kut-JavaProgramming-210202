// 2020136018 김성녕

package BaseballGame;

import java.util.Scanner;
import java.util.regex.Pattern;			// 사용자 입력에서 Y/N을 구분하기 위해 정규식 사용.

// 사용자가 실제로 사용할 사용자와 play 함수를 제외한 모든 멤버 변수, 함수, 클래스들을 private으로 선언.
public class Baseball {
	// Scanner와 N에 대한 정규식 표현은 변할 일이 없으므로 final로 선언.
	private static final Scanner IN = new Scanner(System.in);
	private static final String NO_EXPR = "([Nn][Oo]|[Nn])";
	private static final String YES_EXPR = "([Yy][Ee][Ss]|[Yy])";
	
	private static int[] bat;
	private static int[] ball;
	private static int result;
	private static int out;
	
	// 사용자 입력에 대한 예외를 처리하기 위한 예외 선언.
	public static void play() throws Exception {
		do {
			PlayerInteraction.playGame();
		} while (!PlayerInteraction.done());
	}

	private class PlayerInteraction {
		private static void playGame() {
			bat = new int[3];
			ball = new int[3];
			out = 0;

			GameLogics.pitch(ball);
			
			while (true) {
				System.out.print("[0-9]까지 숫자 3개를 입력하시오: ");
				for (int i = 0; i < 3; i++) {
					bat[i] = IN.nextInt();
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

		// 사용자 입력에 대한 예외를 처리하기 위한 예외 선언.
		private static boolean done() throws Exception {
			System.out.println("새로운 게임을 플레이하시겠습니까? (Y/N)");
			String s = IN.next();
			
			if (Pattern.matches(NO_EXPR, s))
				return true;
			else if (Pattern.matches(YES_EXPR, s))
				return false;
			else
				throw new Exception("유효하지 않은 입력 예외: 유효하지 않은 사용자 입력입니다.");
		}
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