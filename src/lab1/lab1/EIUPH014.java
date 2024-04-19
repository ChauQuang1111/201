package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUPH014 {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int[] numbers = { 0, 2, 5, 11 };
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(Loop(numbers)[i]);
		}
	}
	
	public static int count_Loop(int[] numbers) {
		int count = 0;
		for(var i = 0; i <= 1000; i++) {
			Loop(numbers);
		}
		
		return -1;
	}

	public static int[] Loop(int[] numbers) {
		int[] temp_Numbers = new int[numbers.length];
		for (var i = 0; i < numbers.length - 1; i++) {
			temp_Numbers[i] = Math.abs(numbers[i] - numbers[i + 1]);

		}
		temp_Numbers[temp_Numbers.length - 1] = numbers[numbers.length - 1] - numbers[0];
		numbers = new int[temp_Numbers.length];
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
