import java.io.*;
import java.util.*;

public class Midterm_Question1 {

	static InputReader reader = new InputReader(System.in);
	public static void main(String[] args) {
		int number = reader.nextInt();
		List<Number> numbers = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			long main_number = reader.nextLong();
			Number myNumber = new Number(main_number, i);
			numbers.add(myNumber);
		}
		numbers.sort((n1, n2) -> {
			int compare = Long.compare(n1.main_number, n2.main_number);
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		for (Number num : numbers) {
			myBuffer.append(num.toString());
		}
		System.out.println(myBuffer);
	}
	
	static class Number{
		private long main_number;
		private int index;
		
		public Number(long main_number, int index) {
			super();
			this.main_number = main_number;
			this.index = index;
		}
		@Override
		public String toString() {
			return this.main_number + " " + this.index + "\n";
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
