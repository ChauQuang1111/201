import java.util.*;
import java.io.*;

public class EIUONCE_DistinctValue {

	public static void main(String[] args) {
		InputReader myReader = new InputReader(System.in);
		int test = myReader.nextInt();
		while(test >= 1) {
			int number = myReader.nextInt();
			int[] array = new int[number];
			StringBuffer myBuffer = new StringBuffer();
			for (int i = 0; i < array.length; i++) {
				array[i] = myReader.nextInt();
			}
			Arrays.sort(array);
			for (int j = 0; j < array.length; j++) {
				// Nếu dãy chỉ chứa 1 số thì in nó ra luôn
				// Nếu xét số đầu tiên thì nó phải khác số sau nó
				// Nếu xét số ở giữa thì nó phải khác số trước và sau nó
				// Nếu xét số cuối cùng thì nó phải khác số trước nó
				if (number == 1 || j == 0 && array[j] != array[j + 1]
						|| j > 0 && j < number - 1 && array[j] != array[j - 1] && array[j] != array[j + 1]
						|| j == number - 1 && array[j] != array[j - 1]) {
					myBuffer.append(array[j]).append(" ");
				}
			}
			test -= 1;
			System.out.println(myBuffer);
		}
		

	}

	static class InputReader {

		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

	}
}
