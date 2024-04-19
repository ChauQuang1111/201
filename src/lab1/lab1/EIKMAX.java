package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIKMAX {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var n = reader.nextInt();
		var k = reader.nextInt();
		int[] numbers = new int[n];
		for (var i = 0; i < n; i++) {
			numbers[i] = reader.nextInt();
		}
		int[] temp_Arr = reverse_Arr(numbers);
		for (var m = 0; m < k; m++) {
			System.out.print(temp_Arr[m] + " ");
		}

	}

	public static int[] reverse_Arr(int[] numbers) {
		Arrays.sort(numbers);
		int[] temp_Arr = new int[numbers.length];
		var temp = 0;
		for (var j = numbers.length - 1; j >= 0; j--) {
			temp_Arr[temp] = numbers[j];
			temp++;
		}
		return temp_Arr;
	}

	public static int max_Number(int[] numbers) {
		int max = 0;
		for (var i = 0; i < numbers.length; i++) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		return max;

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