package lab1;

import java.io.*;
import java.util.*;

public class EIMERGESORT {

	public static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {

		int n = reader.nextInt();
		Employee[] arr = new Employee[n];
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			int sales = reader.nextInt();
			arr[i] = new Employee(id, sales);
		}
		mergeSort(arr, 0, n - 1);
		for (Employee e : arr) {
			System.out.println(e.id + " " + e.sales);
		}
	}

	public static void merge(Employee arr[], int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		Employee[] L = new Employee[n1];
		Employee[] R = new Employee[n2];
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[left + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[mid + 1 + j];
		}
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i].sales <= R[j].sales) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void mergeSort(Employee arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
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
