package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUTRANS {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var n = reader.nextInt();
		var m = reader.nextInt();
		StringBuilder sb = new StringBuilder();
		HashMap<String, String> dictionary = new HashMap<>();
		for (int i = 0; i < m; i++) {
			var wordA = reader.next();
			var wordB = reader.next();
			dictionary.put(wordA, wordB);
		}
		for (var i = 0; i < n; i++) {
			var wordA = reader.next();
			var wordB = dictionary.get(wordA);
			if (wordA.length() <= wordB.length()) {
				sb.append(wordA+" ");
			} else {
				sb.append(wordB+ " ");
			}
		}
		System.out.println(sb);
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
