package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIHPROFITS {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt();
		int k = reader.nextInt();

		List<Product> products = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			double cost = reader.nextDouble();
			double price = reader.nextDouble();
			int quantitySold = reader.nextInt();

			products.add(new Product(id, name, price, cost, quantitySold));
		}

		Collections.sort(products, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				int profitCompare = Double.compare(p2.getProfit(), p1.getProfit());
				if (profitCompare != 0) {
					return profitCompare;
				} else {
					return Integer.compare(p1.id, p2.id);
				}
			}
		});

		for (int i = 0; i <= k; i++) {
			Product p = products.get(i);
			System.out.println(p.id + " " + p.name + " " + (int) p.getProfit());
			while (i + 1 < k && Double.compare(p.getProfit(), products.get(i + 1).getProfit()) == 0) {
				i++;
				p = products.get(i);
				System.out.println(p.id + " " + p.name + " " + (int) p.getProfit());
			}
		}
	}

	static class Product {
		int id;
		String name;
		double cost;
		double price;
		int quantitySold;

		public Product(int id, String name, double price, double cost, int quantitySold) {
			this.id = id;
			this.name = name;
			this.cost = cost;
			this.price = price;
			this.quantitySold = quantitySold;
		}

		public double getProfit() {
			return Math.abs((price - cost)) * quantitySold;
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