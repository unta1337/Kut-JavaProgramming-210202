// 기관명: 한국기술교육대학교
// 학년도: 2021 학년도
// 교과목: 자바프로그래밍
// 주차: 3 주차
// 과제명: 객체지향 패턴으로 숫자 야구 게임 작성하기
// 저자: 2020136018 김성녕

package mvc.kr.ac.koreatech.baseball;

public class Game {
	// MVC 패턴 적용.
	private static Model model = new Model();
	private static View view = new View();
	
	// 실제 사용자가 실행할 함수.
	public static void play() {
		do {
			mainLogic();
		} while (!view.done());
	}
	
	// 전반적인 게임의 흐름.
	private static void mainLogic() {
		model.setBats(new int[3]);
		model.setBalls(new int[3]);
		model.setOut(0);
		
		model.initBalls();
		
		outerLoop:
		while (true) {
			model.setBats(view.getUserBats());
			model.setResult(model.evalResult());
			
			switch (model.getResult()) {
				case WIN:
					view.printUserWin();
					break outerLoop;
				case LOSE:
					model.addOut();
					view.printCurrentOut(model.getOut());
					if (model.getOut() == 3) {
						view.printComputerWin();
						break outerLoop;
					}
					break;
				case DRAW:
					int[] strikesAndBalls = model.getStrikesAndBalls();
					view.printCurrentStatus(strikesAndBalls[0], strikesAndBalls[1]);
					break;
			}
		}
	}
}
