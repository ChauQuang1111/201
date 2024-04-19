package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUGIFTS {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var nOfItems = reader.nextInt();
		var money = reader.nextInt();
		var a = new int[nOfItems];
		for (var i = 0; i < nOfItems; i++) {
			a[i] = reader.nextInt();
		}
		Arrays.sort(a);
		var i = 0;
		var j = nOfItems - 1;
		while (i < j) {
			var sum = a[i] + a[j];

			if (sum == money) {
				var min = Math.abs(a[i] - a[j]);
				System.out.println(money + " " + min);
			}
			if (sum < money) {
				i++;
			} else {
				j--;
			}
		}
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
