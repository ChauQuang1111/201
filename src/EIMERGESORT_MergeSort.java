import java.util.*;
import java.io.*;

public class EIMERGESORT_MergeSort {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		Staff[] staffs = new Staff[number];
		int index = 0;
		while (index < staffs.length) {
			int id = reader.nextInt();
			int sale = reader.nextInt();
			staffs[index] = new Staff(id, sale);
			index++;
		}
		MergeSort.mergeSort(staffs, 0, staffs.length - 1);
		StringBuffer mySB = new StringBuffer();
		for (int i = 0; i < staffs.length; i++) {
			mySB.append(staffs[i].toString());
		}
		System.out.println(mySB);
	}

	static class MergeSort {
		static void mergeSort(Staff[] staffs, int from, int to) {
			if (from < to) {
				// tìm điểm giữa
				int mid = (from + to) / 2;
				// đệ quy cho tiếp tục cho mảng
				mergeSort(staffs, from, mid);
				mergeSort(staffs, mid + 1, to);
				merge(staffs, from, mid, to);
			}
		}

		static void merge(Staff[] staffs, int from, int mid, int to) {
			// khai báo kích thước cho 2 mảng con tạm
			int left = mid - from + 1;
			int right = to - mid;
			// tạo mạng tạm L và R
			Staff[] leftArr = new Staff[left];
			Staff[] rightArr = new Staff[right];
			// copy dữ liệu từ mảng chính vào 2 mảng tạm
			for (int i = 0; i < leftArr.length; i++) {
				leftArr[i] = staffs[from + i];
			}
			for (int i = 0; i < rightArr.length; i++) {
				rightArr[i] = staffs[mid + 1 + i];
			}
			// sort các mảng tạm lại

			// vị trí ban đầu của 2 mạng tạm
			int left_idx = 0;
			int right_idx = 0;
			// vị trí ban đầu của mảng được hợp nhất
			int complete = from;
			while (left_idx < left && right_idx < right) {
				if (leftArr[left_idx].sale <= rightArr[right_idx].sale) {
					staffs[complete] = leftArr[left_idx];
					left_idx++;
				} else {
					staffs[complete] = rightArr[right_idx];
					right_idx++;
				}
				complete++;
			}
			//sao chép các phần tử còn lại của leftArr (nếu có)
			while (left_idx < left) {
				staffs[complete] = leftArr[left_idx];
				left_idx++;
				complete++;
			}
			//tương tự
			while (right_idx < right) {
				staffs[complete] = rightArr[right_idx];
				right_idx++;
				complete++;
			}
		}
	}

	static class Staff {
		private int id;
		private int sale;

		public Staff(int id, int sale) {
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
