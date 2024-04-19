package lab1;

import java.util.*;
import java.io.*;

public class EIUCREAM {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		long n = reader.nextLong();
		int m = reader.nextInt();
		long total_IC = n;
		long bonus_IC = n;
		long newTotalIC;
		while (bonus_IC >= m) {
			newTotalIC = n / m;
			total_IC += newTotalIC;
			bonus_IC = newTotalIC + (bonus_IC % m);
		}
		StringBuilder sb = new StringBuilder();
		sb.append(total_IC);
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
