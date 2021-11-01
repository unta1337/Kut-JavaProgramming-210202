// 2020136018 김성녕

import java.util.Scanner;

public class ProbB {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		int[] results = new int[T];

		outer:
		for (int i = 0; i < T; i++) {
			int N = input.nextInt();

			int negativeCount = 0;
			for (int j = 0; j < N; j++) {
				int temp = input.nextInt();

				if (temp == 0) {
					input.nextLine();
					continue outer;
				}

				negativeCount += temp < 0 ? 1 : 0;
			}

			results[i] = negativeCount % 2 == 0 ? 1 : -1;
		}

		for (int i = 0; i < T; i++)
			System.out.println(results[i]);

		input.close();
	}
}
