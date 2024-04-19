package lab1;

import java.util.*;
import java.io.*;

public class EISTULIST {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var n = reader.nextInt();
		List<Student> arr = new ArrayList<>();
		for (var i = 0; i < n; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			int age = reader.nextInt();
			int code = reader.nextInt();
			arr.add(new Student(id, age, code, name));
		}
		arr.sort((s1,s2)->{
			int cp = Integer.compare(s1.id, s2.id);
			return cp;
		});
		
//		Collections.sort(arr, new Comparator<Student>() {
//			public int compare(Student s1, Student s2) {
//				return Integer.compare(s1.id, s2.id);
//			}
//		});
		StringBuilder sb = new StringBuilder();
		for (Student s : arr) {
			sb.append(s.id).append(" ").append(s.name).append(" ").append(s.age).append(" ").append(s.code)
					.append("\n");
		}
		System.out.println(sb);

	}

	static class Student {
		public int id, age, code;
		public String name;

		public Student(int id, int age, int code, String name) {
			this.age = age;
			this.name = name;
			this.code = code;
			this.id = id;
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
