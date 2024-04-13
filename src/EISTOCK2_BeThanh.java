import java.util.*;
import java.io.*;

public class EISTOCK2_BeThanh {

	public static void main(String[] args) {
		InputReader reader = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();

		int trans = reader.nextInt();
		HashMap<Integer, Information> infor = new HashMap<>(); // chua key = code ,

		for (int i = 0; i < trans; i++) {
			String typetrans = reader.next();
			int code = reader.nextInt();
			long quantity = reader.nextLong();
			long money = reader.nextLong();
			int timeInStock = reader.nextInt();
			Information templist = new Information(code); // bo code vao array temp

			if (typetrans.equalsIgnoreCase("+") && !infor.containsKey(code)) {
				// same type but not have code
				templist.checkImAndExport(typetrans, quantity, money, timeInStock);
				infor.putIfAbsent(code, templist); // bo vao HashMap
			} else if (infor.containsKey(code)) { // if HashMap have that code
				infor.get(code).checkImAndExport(typetrans, quantity, money, timeInStock);
				// lay Value tuong ung vs code do roi tinh total

			}
		}
		ArrayList<Information> listInfor = new ArrayList<>(infor.values());

		Collections.sort(listInfor, (s1, s2) -> {
			return Integer.compare(s1.code, s2.code);
		});

		for (int i = 0; i < listInfor.size(); i++) {
			if (listInfor.get(i).tempStock >= 1) {
				sb.append(listInfor.get(i).toString() + "\n");
			}
		}

		System.out.println(sb);
	}

	static class Information {

		String typetrans;
		int code;
		long quantity;
		long totalImport;
		long money;
		long tempStock;
		int timeInStock;
		double averPrice;
		int time;

		public Information(long quantity, long money, int timeInStock) {
			this.quantity = quantity;
			this.money = money;
			this.timeInStock = timeInStock;
		}

		public Information(int code) {

			this.code = code;
		}

		ArrayList<Information> listProduct = new ArrayList<>();

		public void checkImAndExport(String typetrans, long quantity, long money, int timeInStock) {
			if (typetrans.equalsIgnoreCase("+")) {
				Information temp = new Information(quantity, money, timeInStock);
				listProduct.add(temp);
				totalImport += quantity * money;
				tempStock += quantity;
			}
			if (typetrans.equalsIgnoreCase("-")) {
				if (tempStock < quantity) {
					return;
				}
				if (listProduct.size() > 0 && tempStock >= quantity) {
					tempStock -= quantity;
					if (tempStock == 0) {
						listProduct.clear();
					} else { // out< stock
						for (int i = 0; i < listProduct.size(); i++) {
							if (quantity >= listProduct.get(i).quantity) { // out > had import1
								quantity -= listProduct.get(i).quantity;
								totalImport -= listProduct.get(i).quantity * listProduct.get(i).money;
								listProduct.remove(i); // completely out
								i--;

							} else { // out<stock
								totalImport -= quantity * listProduct.get(i).money; // update total
								listProduct.get(i).quantity -= quantity;
								// a part of stock
								break;
							}
							if (quantity == 0) {
								break;
							}

						}
					}
				}
			}
			if (listProduct.size() > 0) {
				averPrice = (double) totalImport / tempStock;
				time = listProduct.get(0).timeInStock;
			}
		}

		@Override
		public String toString() {

			return code + " " + tempStock + " " + (long) averPrice + " " + time;
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

		private float nextFloat() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
	}

}
