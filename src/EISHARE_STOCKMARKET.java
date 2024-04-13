import java.util.*;
import java.io.*;

public class EISHARE_STOCKMARKET {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		int best = reader.nextInt();
		HashMap<String, Item> map_code = new HashMap<>();
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			String type = reader.next();
			String code = reader.next();
			long quantity = reader.nextLong();
			long price = reader.nextLong();
			if (map_code.containsKey(code) == false) {
				Item myItem = new Item(code);
				items.add(myItem);
				map_code.put(code, myItem);
				myItem.calculation(type, quantity, price);
			} else {
				Item temp = map_code.get(code);
				temp.calculation(type, quantity, price);
			}
		}
		items.sort((i1, i2) -> {
			int compare = Double.compare(i2.profit, i1.profit);
			if (compare == 0) {
				compare = i1.code.compareTo(i2.code);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		if (best > items.size()) {
			best = items.size();
		}
		while (best > 0 && best < items.size() && items.get(best).profit == items.get(best - 1).profit) {
			best--;
		}
		for (int i = 0; i < best; i++) {
			myBuffer.append(items.get(i).toString() + "\n");
		}
		System.out.println(myBuffer);
	}

	static class Item {
		private String code;
		private double profit;
		private double total_buy;
		private double total_sell;

		public Item(String code) {
			super();
			this.code = code;
		}

		public void calculation(String type, long quantity, long price) {
			if ("B".equals(type) == true) {
				this.total_buy += quantity * price;
			} else {
				this.total_sell += quantity * price;
			}
			this.profit = this.total_sell * 0.998 - this.total_buy * 1.001;
		}

		@Override
		public String toString() {
			return this.code + " " + Math.round(this.profit) + "\n";
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
