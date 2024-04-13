import java.util.*;
import java.io.*;

public class EIUSESOR_SelectionSort {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int N = reader.nextInt();
		String dataType = reader.next();
		if ("double".equals(dataType)) {
			Double[] array = new Double[N];
			for (int i = 0; i < array.length; i++) {
				array[i] = reader.nextDouble();
			}
			selectionSort(array);
			print(array);
		}
		if ("int".equals(dataType)) {
			Integer[] array = new Integer[N];
			for (int i = 0; i < array.length; i++) {
				array[i] = reader.nextInt();
			}
			selectionSort(array);
			print(array);
		}
		if ("long".equals(dataType)) {
			Long[] array = new Long[N];
			for (int i = 0; i < array.length; i++) {
				array[i] = reader.nextLong();
			}
			selectionSort(array);
			print(array);
		}
		if ("float".equals(dataType)) {
			Float[] array = new Float[N];
			for (int i = 0; i < array.length; i++) {
				array[i] = reader.nextFloat();
			}
			selectionSort(array);
			print(array);
		}
	}

	static <T extends Number & Comparable<T>> void selectionSort(T[] array) {
		// Your code here
		// Compare t[i] and T[j]: t[i].compareTo(T[j])
		int min_idx, i, j;
		for (i = 0; i < array.length - 1; i++) {
			//thiết lập cho "i" là min
			min_idx = i;
			j = i + 1;
			// kiểm tra coi phần tử tiếp theo "j" có bé hơn nó ko, nếu có thì cho j là ptu bé nhất
			while (j < array.length) {
				// arr[j] < arr[min_idx] nhưng k hiểu sao viết thế java nó báo lỗi
				if (array[j].compareTo(array[min_idx]) == -1) {
					min_idx = j;
				}
				j++;
			}
			//sau khi đã tìm ra phần tử nhỏ nhất rồi, thì tráo nó lại với i
			if (min_idx != i) {
				T temp = array[min_idx];
				array[min_idx] = array[i];
				array[i] = temp;
			}
		}
	}

	static <T> void print(T[] array) {
		int index = 0;
		while (index < array.length) {
			System.out.print(array[index] + " ");
			index++;
		}
		System.out.println();
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
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
	}
}