import java.util.*;
import java.io.*;

public class EI20213FQ2_Question2 {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int number = reader.nextInt();
		int best = reader.nextInt();
		HashMap<Long, Product> map_product = new HashMap<>();
		List<Product> products = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			long trans_code = reader.nextLong();
			long product_code = reader.nextLong();
			double price = reader.nextDouble();
			double quantity = reader.nextDouble();
			double cost_per_product = reader.nextDouble();
			if (map_product.containsKey(product_code) == false) {
				Product myProduct = new Product(trans_code, product_code);
				products.add(myProduct);
				map_product.put(product_code, myProduct);
				myProduct.calculation(product_code, price, quantity, cost_per_product);
			} else {
				Product temp = map_product.get(product_code);
				temp.calculation(product_code, price, quantity, cost_per_product);
			}
		}
		products.sort((p1, p2) -> {
			int compare = Double.compare(p2.profit, p1.profit);
			if (compare == 0) {
				compare = Long.compare(p1.product_code, p2.product_code);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		if (best > products.size()) {
			best = products.size();
		}
		while (best > 0 && best < products.size() && products.get(best).profit == products.get(best - 1).profit) {
			best++;
		}
		for (int i = 0; i < best; i++) {
			myBuffer.append(products.get(i).toString());
		}
		System.out.println(myBuffer);
	}
	
	static class Product{
		private long trans_code;
		private long product_code;
		private double total_price;
		private double total_quantity;
		private double profit;
		public Product(long trans_code, long product_code) {
			super();
			this.trans_code = trans_code;
			this.product_code = product_code;
		}
		public void calculation(long product_code, double price, double quantity, double cost_per_product) {
			this.profit += price * quantity - cost_per_product * quantity;	
		}
		@Override
		public String toString() {
			return this.product_code + " " + Math.round(this.profit) + "\n";
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
