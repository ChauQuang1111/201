import java.util.*;
import java.io.*;

public class EIKMAX_KGreatestNumbers {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		StringBuffer myBuffer = new StringBuffer();
		int number = reader.nextInt();
		int greatest = reader.nextInt();
		Integer[] array = new Integer[number];
		for (int i = 0; i < array.length; i++) {
			array[i] = reader.nextInt();
		}
		Arrays.sort(array, (n1, n2) -> n2 - n1);
		for (int i = 0; i < greatest; i++) {
			myBuffer.append(array[i]).append(" ");
		}
		System.out.println(myBuffer);
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
