import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;

public class Baseball {
	// 버퍼에 저장된 값으로 done 함수를 실행하기 위해 전역 Scanner 선언.
	static Scanner _in = new Scanner(System.in);

	public static void main(String[] args) {
		do {
			playGame();
		} while (!done());

		// 전역 Scanner close.
		_in.close();
	}

	static void pitch(int[] ball) {
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
	
	static int compare(int[] ball, int[] bat) {
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
			System.out.println(String.format("S: %d, B: %d", scount, bcount));
			return 0;
		}
	}
	
	static void playGame() {
		int[] bat = new int[3];
		int[] ball = new int[3];
		int result;
		int out = 0;
		
		pitch(ball);
		
		while (true) {
			System.out.print("[0-9]까지 숫자 3개를 입력하시오: ");
			for (int i = 0; i < 3; i++) {
				bat[i] = _in.nextInt();
			}
			result = compare(ball, bat);
			
			if (result == 1) {
				System.out.println("사용자 승");
				break;
			} else if (result == -1) {
				++out;
				System.out.println(String.format("OUT: %d", out));
				
				if (out == 3) {
					System.out.println("컴퓨터 승");
					break;
				}
			}
		}
	}
	
	static boolean done() {
		System.out.print("새 게임(y/n)? ");
		
		// Scanner는 버퍼에 저장된 값을 읽어오므로 게임 종료 이후에는 사용자 입력이 없어 NoSuchElement 예외를 발생시킨다.
		// 따라서 Scanner를 전역으로 선언, 버퍼에 남아 있는 값을 불러올 수 있게 함으로써 에외를 방지한다.
		String s = _in.next();
		
		return s.toLowerCase().equals("n");
	}
}