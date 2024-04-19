package lab1;

import java.io.*;
import java.util.*;

public class EI2122Q1ADAM2 {

	public static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {

		int n = reader.nextInt();
		int m = reader.nextInt();
		int x = reader.nextInt();
		int[] men = new int[n];
		int[] women = new int[m];
		for (int i = 0; i < n; i++) {
			men[i] = reader.nextInt();
		}
		for (int i = 0; i < m; i++) {
			women[i] = reader.nextInt();
		}
		Arrays.sort(men);
		Arrays.sort(women);
		int low = 0;
		int high = women[m - 1] - men[0];
		while (low < high) {
			int mid = (low + high) / 2;
			int pairs = 0;
			int i = 0;
			int j = 0;
			while (i < n && j < m) {
				if (Math.abs(men[i] - women[j]) <= mid) {
					pairs++;
					i++;
					j++;
				} else if (men[i] < women[j]) {
					i++;
				} else {
					j++;
				}
			}
			if (pairs >= x) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(low);
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
