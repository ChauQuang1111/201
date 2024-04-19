package lab1;

import java.util.*;
import java.io.*;

public class EIUSTUDE {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		int n = reader.nextInt();
		List<Student> students_List = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			students_List.add(new Student(reader.nextLine()));
		}
//		Collections.sort(students_List, new Comparator<Student>() {
//			public int compare(Student s1, Student s2) {
//				int cp = s1.firstName.compareTo(s2.firstName);
//				if (cp == 0) {
//					cp = s1.lastName.compareTo(s2.lastName);
//					if (cp == 0) {
//						cp = s1.middleName.compareTo(s2.lastName);
//					}
//				}
//				return cp;
//
//			}
//		});

		students_List.sort((s1, s2) -> {
			var compare = s1.firstName.compareTo(s2.firstName);
			if (compare == 0) {
				compare = s1.lastName.compareTo(s2.lastName);
				if (compare == 0) {
					compare = s1.middleName.compareTo(s2.middleName);
				}
			}
			return compare;
		});
		StringBuffer sb = new StringBuffer();
		for (var student : students_List) {
			sb.append(student).append("\n");
		}
		System.out.println(sb);

	}

	static class Student {
		public String lastName;
		public String middleName;
		public String firstName;

		public Student(String fullName) {
			var lastIndex = fullName.lastIndexOf(" ");
			firstName = fullName.substring(lastIndex + 1);
			var firstIndex = fullName.indexOf(" ");
			lastName = fullName.substring(0, firstIndex);
			middleName = fullName.substring(firstIndex, lastIndex);
		}

		@Override
		public String toString() {
			return lastName + " " + middleName + " " + firstName;
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
