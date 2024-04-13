import java.util.*;
import java.io.*;

public class EILAPTOP2_QualityAndValue {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		List<Laptop> laptops = new ArrayList<>();
		for (int i = 0; i < number; i++) {
			long price = reader.nextLong();
			long speed = reader.nextLong();
			Laptop myLaptop = new Laptop(price, speed);
			laptops.add(myLaptop);
		}
		laptops.sort((l1, l2) -> {
			int compare = Long.compare(l1.price, l2.price);
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		if (compareSpeed(laptops)) {
			myBuffer.append("Happy Beo");
		} else {
			myBuffer.append("Poor Beo");
		}
		System.out.println(myBuffer);
	}

	static boolean compareSpeed(List<Laptop> laptops) {
		for (int i = 0; i < laptops.size() - 1; i++) {
			if (laptops.get(i).speed > laptops.get(i + 1).speed) {
				return true;
			}
		}
		return false;
	}

	static class Laptop {
		private long price;
		private long speed;

		public Laptop(long price, long speed) {
			super();
			this.price = price;
			this.speed = speed;
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
