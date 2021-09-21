// 2020136018 김성녕

package MainPackage;

import java.util.Scanner;
import BaseballGame.Baseball;

public class MainClass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Baseball game = new Baseball(in);
		
		game.play();
		
		in.close();
	}
}