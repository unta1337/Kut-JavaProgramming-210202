// 2020136018 김성녕

import java.util.Scanner;

public class ProbA {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int T = input.nextInt();
		int[] results = new int[T];

		for (int i = 0; i < T; i++) {
			int M = input.nextInt();
			int N = input.nextInt();
			int K = input.nextInt();

			int[][] matrix = new int[M][N];

			for (int j = 0; j < K; j++) {
				int[] indexPair = new int[2];
				indexPair[0] = input.nextInt();
				indexPair[1] = input.nextInt();

				updateMatrix(matrix, indexPair);

				results[i] = countOdds(matrix);
			}
		}
		
		for (int i = 0; i < T; i++)
			System.out.println(results[i]);

		input.close();
	}

	public static void updateMatrix(int[][] matrix, int[] arg) {
		updateRows(matrix, arg[0]);
		updateCols(matrix, arg[1]);
	}

	public static void updateRows(int[][] matrix, int arg) {
		for (int i = 0; i < matrix[arg].length; i++)
			matrix[arg][i]++;
	}

	public static void updateCols(int[][] matrix, int arg) {
		for (int i = 0; i < matrix.length; i++)
			matrix[i][arg]++;
	}

	public static int countOdds(int[][] matrix) {
		int oddCount = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] % 2 == 1)
					oddCount++;
			}
		}

		return oddCount;
	}
}
