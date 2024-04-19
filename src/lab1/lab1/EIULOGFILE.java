package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIULOGFILE {
	public static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var n = reader.nextInt();
		List<Long> logs = new ArrayList<Long>();
		for (var i = 0; i < n; i++) {
			logs.add(reader.nextLong());
		}
		Collections.sort(logs);
		long count = 0;
		for (var i = 0; i < n ; i++) {

			var index = Collections.binarySearch(logs, logs.get(i) + 600000);
			if (index < 0) {
				index = ~index;
			} else {
				while (index < n && logs.get(index).equals(logs.get(i) + 600000)) {
					index++;
				}
			}

			count += (index - i - 1);
		}
		System.out.println(count);
	}

//	public static int binarySearch(long[] logs, int left, int right, long target) {
//		while (left <= right) {
//			int mid = (left + right) / 2;
//			if (logs[mid] <= target) {
//				left = mid + 1;
//			} else {
//				right = mid - 1;
//			}
//		}
//		return left;
//	}

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