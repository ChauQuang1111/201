import java.util.*;
import java.io.*;

public class insertion_sort_example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public void sort(int[] numbers, int i) {
		for (int j = 0; j < numbers.length; j++) {
			insert(numbers, i);
		}
	}
	
	static public void insert(int[] numbers, int i) {
		int current = numbers[i];
		while ((i > 0) && (numbers[i - 1] > current)) {
			numbers[i] = numbers[i - 1];
			i--;
		}
		numbers[i] = current;
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
