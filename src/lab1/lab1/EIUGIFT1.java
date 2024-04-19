package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUGIFT1 {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var nOfGifts = reader.nextInt();
		var nOfPapers = reader.nextInt();
		var giftSize = new int[nOfGifts];
		var paperSize = new double[nOfPapers];
		var count = 0;

		for (var i = 0; i < giftSize.length; i++) {
			giftSize[i] = reader.nextInt();
		}
		Arrays.sort(giftSize);
		for (var j = 0; j < paperSize.length; j++) {
			paperSize[j] = reader.nextDouble();
		}
		Arrays.sort(paperSize);

		var a = 0;
		var b = 0;
		while (a < nOfGifts && b < nOfPapers) {
			if (paperSize[b] / giftSize[a] >= 2 && paperSize[b] / giftSize[a] <= 3) {
				count++;
				a++;
				b++;
			} else if (paperSize[b] / giftSize[a] < 2) {
				b++;
			} else {
				a++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count);
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
