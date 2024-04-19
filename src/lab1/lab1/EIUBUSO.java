package lab1;

import java.io.*;
import java.util.*;

public class EIUBUSO {

	public static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int N = reader.nextInt();
		String dataType = reader.next();
		if (dataType.equals("double")) {
			Double[] array = new Double[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextDouble();
			}
			selectionSort(array);
			for (int i = 0; i < N; i++) {
				System.out.print(array[i] + " ");
			}
		} else if (dataType.equals("int")) {
			Integer[] array = new Integer[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextInt();
			}
			selectionSort(array);
			for (int i = 0; i < N; i++) {
				System.out.print(array[i] + " ");
			}
		} else if (dataType.equals("long")) {
			Long[] array = new Long[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextLong();
			}
			selectionSort(array);
			for (int i = 0; i < N; i++) {
				System.out.print(array[i] + " ");
			}
		} else if (dataType.equals("float")) {
			Float[] array = new Float[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextFloat();
			}
			insertionSort(array);
			// bubbleSort(array);
			// selectionSort(array);
			for (int i = 0; i < N; i++) {
				System.out.print(array[i] + " ");
			}
		}
	}

	static <T extends Number & Comparable<T>> void insertionSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	static <T extends Number & Comparable<T>> void selectionSort(T[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j].compareTo(array[minIndex]) < 0) {
					minIndex = j;
				}
			}
			T temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}

	static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					T temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
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

		public float nextFloat() {
			return Float.parseFloat(next());
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
