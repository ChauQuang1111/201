import java.util.*;
import java.io.*;

public class EIHPROFIT_TheHighestProfitableProduct {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num = reader.nextInt();
		int num_of_products = num;
		int best = reader.nextInt();
		List<Product> products = new ArrayList<>();
		while (num >= 1) {
			int id = reader.nextInt();
			String name = reader.next();
			long cost = reader.nextLong();
			long price = reader.nextLong();
			long quantity = reader.nextLong();
			Product myProduct = new Product(id, name, cost, price, quantity);
			myProduct.cal_total();
			products.add(myProduct);
			num--;
		}
		products.sort((p1, p2) -> {
			int compare = Long.compare(p2.total, p1.total);
			if (compare == 0) {
				compare = Integer.compare(p1.id, p2.id);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		if (best >= num_of_products) {
			for (int i = 0; i < best; i++) {
				myBuffer.append(products.get(i).toString());
			}
		} else {
			for (int i = 0; i < num_of_products; i++) {
				if (products.get(i).total >= products.get(best - 1).total) {
					myBuffer.append(products.get(i).toString());
				} else {
					break;
				}
			}
		}
		System.out.println(myBuffer);
	}

	static class Product {
		private int id;
		private String name;
		private long cost;
		private long price;
		private long quantity;
		private long total = 0;

		public Product(int id, String name, long cost, long price, long quantity) {
			super();
			this.id = id;
			this.name = name;
			this.cost = cost;
			this.price = price;
			this.quantity = quantity;
		}
		public void cal_total() {
			this.total = (cost - price) * quantity;
		}
		@Override
		public String toString() {
			return this.id + " " + this.name + " " + this.total + "\n";
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
