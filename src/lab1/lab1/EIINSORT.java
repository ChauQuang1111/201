package lab1;

import java.io.*;
import java.util.*;
// insertion sort
public class EIINSORT {

	public static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {

		int n = reader.nextInt();
		Employee[] employees = new Employee[n];
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			int sales = reader.nextInt();
			employees[i] = new Employee(id, sales);
		}
		insertionSort(employees);
		for (Employee employee : employees) {
			System.out.println(employee.id + " " + employee.sales);
		}
	}

	private static void insertionSort(Employee[] employees) {
		for (int i = 1; i < employees.length; i++) {
			Employee current = employees[i];
			int j = i - 1;
			while (j >= 0 && employees[j].sales > current.sales) {
				employees[j + 1] = employees[j];
				j--;
			}
			employees[j + 1] = current;
		}
	}

	static class Employee {
		public int id;
		public int sales;

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
