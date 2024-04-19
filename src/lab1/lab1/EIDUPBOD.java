package lab1;

import java.io.*;
import java.util.*;

public class EIDUPBOD {
	
	static InputReader reader = new InputReader(System.in);

	private Map<String, Integer> birthdayCount;

	public EIDUPBOD() {
		birthdayCount = new HashMap<>();
	}

	public void addStudentBirthday(int day, int month, int year) {
		String birthday = String.format("%02d/%02d/%04d", day, month, year);
		birthdayCount.put(birthday, birthdayCount.getOrDefault(birthday, 0) + 1);
	}

	public void printBirthdayCount() {
		for (Map.Entry<String, Integer> entry : birthdayCount.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		int n = reader.nextInt();
		EIDUPBOD birthdayList = new EIDUPBOD();
		for (int i = 0; i < n; i++) {
			int day = reader.nextInt();
			int month = reader.nextInt();
			int year = reader.nextInt();
			birthdayList.addStudentBirthday(day, month, year);
		}
		birthdayList.printBirthdayCount();
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
