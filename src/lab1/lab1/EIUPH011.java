package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EIUPH011 {
	public static void main(String[] args) {
		InputReader rd = new InputReader(System.in);
		int nOfArr = rd.nextInt();
		int[] myArr = new int[nOfArr];
		for (int i = 0; i < nOfArr; i++) {
			myArr[i] = rd.nextInt();
		}

		for (int i = 0; i < myArr.length; i++) {
			int flag = 0;
			int num = myArr[i];
			for (int j = 0; j < i; j++) {
				if (myArr[j] == num) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.print(myArr[i] + " ");
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
