import java.util.*;
import java.io.*;

public class Midterm_Question3 {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[] arr = new int[n];
		int[] arr_res = new int[m];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.nextInt();
		}
		Arrays.sort(arr);
		for (int j = 0; j < m; j++) {
			int search = reader.nextInt();
			arr_res[j] = count_lessOrEqual(arr, search);
		}
		StringBuffer myBuffer = new StringBuffer();
		for (int i = 0; i < arr_res.length; i++) {
			myBuffer.append(arr_res[i]).append(" ");
		}
		System.out.println(myBuffer);	
	}
	
	static int count_lessOrEqual(int[] arr, int x) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {	
			if (arr[i] <= x) {
				count += 1;
			} else {
				break;
			}
			
		}
		return count;
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
