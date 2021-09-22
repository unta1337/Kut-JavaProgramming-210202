package kr.ac.koreatech.baseball;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
	private static Model model = new Model();
	private static View view = new View();
	
	public static void play() {
		do {
			mainLogic();
		} while (!view.done());
	}
	
	private static void mainLogic() {
		model.setBats(new int[3]);
		model.setBalls(new int[3]);
		model.setOut(0);
		
		model.initBalls();
		System.out.println(Arrays.stream(model.getBalls()).boxed().collect(Collectors.toList()));
		
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
