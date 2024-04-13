import java.util.*;
import java.io.*;

public class EIINSORT_BanHang {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		Staff[] staffs = new Staff[number];
		int i = 0;
		while (i < staffs.length) {
			long id = reader.nextLong();
			int sale = reader.nextInt();
			staffs[i] = new Staff(id, sale);
			i++;
		}
		sort(staffs);
		StringBuffer myBuffer = new StringBuffer();
		for (Staff s : staffs) {
			myBuffer.append(s.toString());
		}
		System.out.println(myBuffer);

	}

	static public void sort(Staff[] staffs) {
		int n = staffs.length;
		for (int i = 0; i < n; ++i) {
			insert(staffs, i);
		}
	}

	static private void insert(Staff[] staffs, int i) {
		Staff key = staffs[i];
		// cách của thầy Ngọc, gọn hơn, dễ hiểu hơn
		while (i > 0 && staffs[i - 1].sale > key.sale) {
			staffs[i] = staffs[i - 1];
			i--;
		}
		staffs[i] = key;
	}

	static class Staff {
		private long id;
		private int sale;

		public Staff(long id, int sale) {
			super();
			this.id = id;
			this.sale = sale;
		}

		@Override
		public String toString() {
			return this.id + " " + this.sale + "\n";
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
