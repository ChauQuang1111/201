package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUPH005 {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int age = reader.nextInt();
		String gender = reader.next();

		StringBuilder sb = new StringBuilder();

		if (age <= 5) {
			sb.append("Be");
		} else if (age <= 20) {
			sb.append("Em");
		} else if (age <= 35) {
			if (gender.equalsIgnoreCase("Nam")) {
				sb.append("Anh");
			} else {
				sb.append("Chi");
			}
		} else if (age <= 60) {
			if (gender.equalsIgnoreCase("Nam")) {
				sb.append("Chu");
			} else {
				sb.append("Co");
			}
		} else {
			if (gender.equalsIgnoreCase("Nam")) {
				sb.append("Ong");
			} else {
				sb.append("Ba");
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
