package lab1;

import java.io.*;
import java.util.*;

public class EISTOCK {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {

		var n = reader.nextInt();
		Map<Integer, Product> inventory = new HashMap<>();

		for (var i = 0; i < n; i++) {
			var s = reader.next();
			var code = reader.nextInt();
			var quantity = reader.nextInt();
			var price = reader.nextInt();

			if (s.equals("+")) {
				if (!inventory.containsKey(code)) {
					inventory.put(code, new Product(code));
				}
				inventory.get(code).importProduct(quantity, price);
			} else {

				if (inventory.containsKey(code)) {
					inventory.get(code).exportProduct(quantity, price);
				}
			}
		}

		List<Integer> codes = new ArrayList<>(inventory.keySet());
		Collections.sort(codes);
		StringBuilder sb = new StringBuilder();
		for (var code : codes) {
			Product product = inventory.get(code);
			if (product.totalImportValue > 0 || product.totalExportValue > 0) {
				sb.append(code).append(" ").append(product.totalImportValue).append(" ")
						.append(product.totalExportValue).append("\n");

			}
		}
		System.out.println(sb);
	}

	static class Product {

		public int code;
		public int quantity;
		public long totalImportValue;
		public long totalExportValue;

		public Product(int code) {
			this.code = code;
		}

		public void importProduct(int quantity, int price) {
			this.quantity += quantity;
			this.totalImportValue += (long) quantity * price;
		}

		public boolean exportProduct(int quantity, int price) {
			if (this.quantity < quantity) {
				return false;
			}
			this.quantity -= quantity;
			this.totalExportValue += (long) quantity * price;
			return true;
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