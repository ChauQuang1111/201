package lab1;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class insertion_Sort {

	static InputReader reader = new InputReader(System.in);

	public static void main(String args[]) {
		var n = reader.nextInt();
		HashMap<Integer, Integer> map = new HashMap<>();
		LinkedHashMap<Integer, Integer> s_map = new LinkedHashMap<>();
		var list = new int[n];
		for (var i = 0; i < n; i++) {
			var ID = reader.nextInt();
			var sales = reader.nextInt();
			list[i] = sales;
			map.put(ID, sales);
		}
		sort(list);
		StringBuilder sb = new StringBuilder();
		for (var num : list) {
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue().equals(num)) {
					s_map.put(entry.getKey(), num);

				}
			}
		}
		for (Map.Entry m : s_map.entrySet()) {
			sb.append(m.getKey()).append(" ").append(m.getValue()).append("\n");
		}

		System.out.println(sb);
	}

	public static int[] sort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
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
