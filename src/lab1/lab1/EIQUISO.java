package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class EIQUISO {

	public static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {

		int n = reader.nextInt();
		Employee[] arr = new Employee[n];
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			int sales = reader.nextInt();
			arr[i] = new Employee(id, sales);
		}
		bubbleSort(arr);
		// insertionSort(arr);
		// selectionSort(arr);
		// quickSort(arr, 0, n - 1);
		for (Employee e : arr) {
			System.out.println(e.id + " " + e.sales);
		}
	}

	public static void quickSort(Employee[] arr, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(arr, left, right);
			quickSort(arr, left, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, right);
		}
	}

	public static void bubbleSort(Employee[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].sales > arr[j + 1].sales) {
					Employee temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void insertionSort(Employee[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			Employee key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].sales > key.sales) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public static void selectionSort(Employee[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j].sales < arr[minIndex].sales) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(arr, i, minIndex);
			}
		}
	}

	public static int partition(Employee[] arr, int left, int right) {
		int pivotValue = arr[right].sales;
		int pivotIndex = left - 1;
		for (int i = left; i < right; i++) {
			if (arr[i].sales < pivotValue) {
				pivotIndex++;
				swap(arr, pivotIndex, i);
			}
		}
		swap(arr, pivotIndex + 1, right);
		return pivotIndex + 1;
	}

	public static void swap(Employee[] arr, int i, int j) {
		Employee temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static class Employee {
		int id;
		int sales;

		public Employee(int id, int sales) {
			this.id = id;
			this.sales = sales;
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
