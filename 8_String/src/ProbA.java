// 2020136018 김성녕

import java.util.Scanner;
import java.util.Arrays;

public class ProbA {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();

		for (int i = 0; i < T; i++) {
			int N = input.nextInt();
			RedundancyTracker[] inputs = new RedundancyTracker[N];

			for (int j = 0; j < N; j++) {
				String inputLocal = input.next();
				inputs[j] = new RedundancyTracker(inputLocal);
			}

			for (int j = 0; j < 24; j++) {
				int[] rcCounts = new int[N];
				for (int k = 0; k < N; k++) {
					rcCounts[k] = inputs[k].getCount((char)((int)'a' + j));
				}

				Arrays.sort(rcCounts);
				int numOfLetters = rcCounts[0];

				for (int k = 0; k < numOfLetters; k++)
					System.out.print((char)((int)'a' + j));
			}

			System.out.println();
		}

		input.close();
	}
}

class RedundancyTracker {
	private String str;
	private int[] count = new int[24];

	RedundancyTracker(String str) {
		this.str = str;

		for (int i = 0; i < str.length(); i++) {
			this.count[(int)this.str.charAt(i) - (int)'a']++;
		}
	}

	String getString() {
		return str;
	}

	int getCount(char chr) {
		return count[(int)chr - (int)'a'];
	}
}
