// 2020136018 김성녕

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ProbB {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Pattern pattern = Pattern.compile("(\\d)(?!((#)|(\\d#)))");

		int T = input.nextInt();
		String[] results = new String[T];

		for (int i = 0; i < T; i++) {
			String str = input.next();
			Matcher matcher = pattern.matcher(str);

			String newStr = matcher.replaceAll("$1#");

			String[] codes = newStr.split("#");
			String result = "";

			for (String s : codes)
				result += Character.toString((char)(Integer.parseInt(s) + (int)'a' - 1));

			results[i] = result;
		}

		for (String s : results)
			System.out.println(s);

		input.close();
	}
}
