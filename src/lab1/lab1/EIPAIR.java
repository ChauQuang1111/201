package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIPAIR {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var testCase = reader.nextInt();
		for (var i = 0; i < testCase; i++) {
			var count = 0;
			var nOfGifts = reader.nextInt();
			HashMap<Integer, Integer> freqMap = createDisMap(nOfGifts);

			for (Map.Entry m : freqMap.entrySet()) {
				count += toHop((int) m.getValue(), 2);
			}
			System.out.println(count);
		}

	}

	public static HashMap<Integer, Integer> createDisMap(int nOfGifts) {
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (var j = 0; j < nOfGifts; j++) {
			var prices = reader.nextInt();
			Integer count = freqMap.getOrDefault(prices, 0);
			count++;
			freqMap.put(prices, count);
		}
		return freqMap;
	}

	public static int toHop(int n, int k) {
		var s = giaithua(n - k);
		var toHop = giaithua(n) / (giaithua(k) * s);
		return toHop;
	}

	public static int giaithua(int number) {
		if (number > 0) {
			return number * giaithua(number - 1);
		} else {
			return 1;
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
