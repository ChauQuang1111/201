package lab1;

import java.io.*;
import java.util.*;

public class EISTOCK2 {

	public static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		var numberOfTransaction = reader.nextInt();
		Hashtable<Integer, product> map = new Hashtable<>();

		for (var i = 0; i < numberOfTransaction; i++) {
			var typeOfTransaction = reader.next();
			var code = reader.nextInt();
			var quantity = reader.nextLong();
			var price = reader.nextLong();
			var time = reader.nextInt();

			product product = map.get(code);
			// put product theo code
			if (product == null) {
				product = new product(code, time);
				map.put(code, product);
			}
			if (typeOfTransaction.equals("+")) {
				product.calculateTotalImport(quantity, price, time);
			} else {
				product.calculateTotalExport(quantity, price);
			}
		}
		
		var values = map.values();
		
		var products = new ArrayList<>(values);
		for (product product : products) {
			product.calculatePriceAndQuantity();
		}
		Collections.sort(products, (s1, s2) -> {
			int compare = Integer.compare(s1.code, s2.code);
			return compare;
		});

		for (product product : products) {
			sb.append(product).append("\n");

		}

		System.out.println(sb);
	}

	static class product {
		public int code;
		public int time;
		public long totalImport;
		public long totalExport;
		public long currentQuantity;
		public double avgValueOfEachProduct;
		public long totalPrice;
		public int oldestTime;
		LinkedList<priceAndQuantity> priceAndQuantity = new LinkedList<>();

		public product(int code, int time) {
			this.code = code;
			this.time = time;
		}

		public void calculateTotalImport(long quantity, long price, int time) {
			priceAndQuantity.add(new priceAndQuantity(quantity, price, time));

			totalImport += quantity * price;
			currentQuantity += quantity;
		}

		public void calculateTotalExport(long quantity, long price) {
			long temp = 0;
			if (quantity <= currentQuantity) { // số lượng xuất mà lớn hơn số lượng có, ko làm
				currentQuantity -= quantity;
				while (quantity > 0) {// vòng lặp này để thực hiện xuất: peek() lấy ra phần tử đầu tiên mà ko xóa khỏi linkedlist
					// gán số lượng stock của phần tử đầu vào temp-> sau đó thực hiện việc trừ số lượng của phần tử đầu.
					temp = priceAndQuantity.peek().quantity;
					priceAndQuantity.peek().quantity -= quantity;
					//kiểm tra xem số lượng stock của phần tử đầu có còn ko, ko thì xóa khỏi list
					if (priceAndQuantity.peek().quantity <= 0) {
						priceAndQuantity.poll();
					}
					quantity -= temp;// trừ SL stock bán
				}
			}
		}

		public void calculatePriceAndQuantity() {
			priceAndQuantity n = priceAndQuantity.poll();
			if (n == null) {
				return;
			}
			oldestTime = n.time;
			while (n != null) {
				totalPrice += n.price * n.quantity;
				n = priceAndQuantity.poll();
			}
			avgValueOfEachProduct = (double) totalPrice / currentQuantity;
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			if (oldestTime > 0) {
				result.append(code).append(" ").append(currentQuantity).append(" ")
						.append((long) avgValueOfEachProduct).append(" ").append(oldestTime);
			}
			return result.toString();
		}

	}

	static class priceAndQuantity {
		public long quantity;
		public long price;
		public int time;

		public priceAndQuantity(long quantity, long price, int time) {
			this.quantity = quantity;
			this.price = price;
			this.time = time;
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