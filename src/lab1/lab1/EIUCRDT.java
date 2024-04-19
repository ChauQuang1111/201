package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUCRDT {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		Integer number = reader.nextInt();
		HashMap<String, Integer> fs_Map = new HashMap<>();
		int totalCre = 0;

		for (var i = 0; i < number; i++) {
			var course = reader.next();
			Integer nOC = reader.nextInt();
			fs_Map.put(course, nOC);
		}
		for (var i = 0; i < number; i++) {
			Integer marks = reader.nextInt();
			var course = reader.next();
			if (marks >= 50) {
				totalCre += fs_Map.get(course);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(totalCre);
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
