import java.util.*;
import java.io.*;

public class EIULOGFILE_KiemTraHeThongWebsites {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int number = reader.nextInt();
		long[] arr = new long[number];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextLong();
		}
		Arrays.sort(arr);
		long count = 0;
		int j = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			for (; j < arr.length; j++) {
				if (arr[j] - arr[i] > 600000) {
					break;
				}
				count += j - i;
			}
		}
		System.out.println(count);
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
