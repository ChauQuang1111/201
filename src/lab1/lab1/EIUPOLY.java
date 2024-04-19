package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUPOLY {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int testCase = reader.nextInt();

		for (int l = 0; l < testCase; l++) {
			int n = reader.nextInt();
			double x = reader.nextDouble();
			double[] coefficients = new double[n + 1];
			for (int i = 0; i < coefficients.length; i++) {
				coefficients[i] = reader.nextDouble();
			}
			double[] revert_Coe = revertArr(coefficients);
			double polynomial = polynomial(revert_Coe, x);
			System.out.println(polynomial);
		}

	}

	public static double polynomial(double[] numbers, double x) {
		double polynomial = 0;
		for (int i = 0; i < numbers.length; i++) {
			polynomial += (double) (numbers[i] * Math.pow(x, i));
		}
		return polynomial;
	}

	public static double[] revertArr(double[] numbers) {
		for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
			double temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		return numbers;
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
