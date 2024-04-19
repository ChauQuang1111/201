package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUONCE {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int testCase = reader.nextInt();
		for (var i = 0; i < testCase; i++) {
			var number = reader.nextInt();
			HashMap<Integer, Integer> freqMap = createDisMap(number);
			for (Map.Entry m : freqMap.entrySet()) {
				if (m.getValue().equals(1)) {
					System.out.print(m.getKey() + " ");
				}
			}
		}
	}

	public static HashMap<Integer, Integer> createDisMap(int number) {
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (var j = 0; j < number; j++) {
			var value = reader.nextInt();
			Integer count = freqMap.getOrDefault(value, 0);
			count++;
			freqMap.put(value, count);
		}
		return freqMap;
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
