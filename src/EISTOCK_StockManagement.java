import java.util.*;
import java.io.*;

public class EISTOCK_StockManagement {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		List<Inventory> inventories = new ArrayList<>();
		Hashtable<Integer, Inventory> mapCode = new Hashtable<>();
		while (number >= 1) {
			String type_trans = reader.next();
			int code = reader.nextInt();
			int quantity = reader.nextInt();
			long price = reader.nextLong();
			if (mapCode.containsKey(code) == false) {
				if ("+".equals(type_trans) == true) {
					Inventory myInventory = new Inventory(code);
					inventories.add(myInventory);
					mapCode.put(code, myInventory);
					myInventory.calculation(type_trans, quantity, price);
				}
			} else {
				Inventory temp_Inventory = mapCode.get(code);
				temp_Inventory.calculation(type_trans, quantity, price);
			}
			number--;
		}
		inventories.sort((i1, i2) -> {
			int compare = Integer.compare(i1.code, i2.code);
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		for (Inventory inv : inventories) {
			myBuffer.append(inv.toString());
		}
		System.out.println(myBuffer);
	}

	static class Inventory {
		private int code;
		private int num_im = 0;
		private long total_ex = 0;
		private long total_im = 0;

		public Inventory(int code) {
			super();
			this.code = code;
		}

		public void calculation(String type_trans, long quantity, long price) {
			if ("+".equals(type_trans) == true) {
				num_im += quantity;
				total_im += (quantity * price);
			} else {
				if (quantity <= num_im) {
					total_ex += (quantity * price);
					num_im -= quantity;
				}
			}
		}

		@Override
		public String toString() {
			return this.code + " " + this.total_im + " " + this.total_ex + "\n";
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
