// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 3 주차
// 과제명: 객체지향 패턴으로 숫자 야구 게임 작성하기
// 저자: 2020136018 김성녕

package mvc.kr.ac.koreatech.baseball;

import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
	private static final Scanner IN = new Scanner(System.in);
	
	private static final String NO_EXPR = "([Nn][Oo]|[Nn])";
	private static final String YES_EXPR = "([Yy][Ee][Ss]|[Yy])";
	
	// 순수 입력.
	String getStringInput() {
		return IN.next();
	}

	int getIntInput() {
		return IN.nextInt();
	}

	// 입력 및 처리.
	int[] getUserBats() {
		int[] bats = new int[3];
		
		System.out.print("Enter your three numbers 1 through 3: ");
		for (int i = 0; i < 3; i++)
			bats[i] = getIntInput();
		
		return bats;
	}
	
	boolean done() {
		while (true) {
			System.out.print("Continue? (Y/N): ");
			String input = getStringInput();
			
			if (Pattern.matches(NO_EXPR, input))
				return true;
			else if (Pattern.matches(YES_EXPR, input)) {
				System.out.println();
				return false;
			}
			else
				System.out.print("Invalid input, ");
				continue;
		}
	}

	// 순수 출력.
	void printCurrentStatus(int strikes, int balls) {
		System.out.printf("Strikes:\t%d\n", strikes);
		System.out.printf("Balls:\t\t%d\n\n", balls);
	}
	
	void printCurrentOut(int outs) {
		System.out.printf("Outs:\t\t%d\n\n", outs);
	}
	
	void printUserWin() {
		System.out.println("User Wins!\n");
	}

	void printComputerWin() {
		System.out.println("Computer Wins!\n");
	}
}
