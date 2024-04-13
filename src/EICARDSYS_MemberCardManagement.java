import java.util.*;
import java.io.*;

public class EICARDSYS_MemberCardManagement {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		long[] purchases = { 1000000, 20000000, 50000000, 200000000, Long.MAX_VALUE };
		double[] sales = { 0.02, 0.03, 0.05, 0.07 };
		double discount = 0;
		HashMap<String, Long> myDictionary = new HashMap<>();
		while (number >= 1) {
			String id = reader.next();
			long pay = reader.nextLong();
			Long paid_before = myDictionary.get(id);
			if (paid_before == null) {
				paid_before = (long) 0;
			}
			for (int i = 0; i < sales.length; i++) {
				if (paid_before >= purchases[i] && paid_before < purchases[i + 1]) {
					discount += (double) pay * sales[i];
					break;
				}
			}
			myDictionary.put(id, paid_before + pay);

			number--;
		}
		System.out.printf("%.2f", discount);
		/*
		 * 5 KH00000001 3000000 KH00000002 12000000 KH00000001 30000000 KH00000002
		 * 8000000 KH00000002 80000000 Output: 3160000
		 */
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
