import java.util.*;
import java.io.*;

public class EISTULIST_TheListOfStudents {

	public static void main(String[] args) {
		InputReader myReader = new InputReader(System.in);
		List<Student> students = new ArrayList<>();
		StringBuffer myBuffer = new StringBuffer();
		int number = myReader.nextInt();
		for (int i = 0; i < number; i++) {
			long id = myReader.nextLong();
			String name = myReader.next();
			int age = myReader.nextInt();
			int majorCode = myReader.nextInt();
			Student myStudent = new Student(id, name, age, majorCode);
			students.add(myStudent);
		}
		students.sort((s1, s2) -> Long.compare(s1.id, s2.id));
		for (Student stu : students) {
			myBuffer.append(stu.toString());
		}
		System.out.println(myBuffer);
	}

	static class Student {
		private long id;
		private String name;
		private int age;
		private int majorCode;

		public Student(long id, String name, int age, int majorCode) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.majorCode = majorCode;
		}

		@Override
		public String toString() {
			return this.id + " " + this.name + " " + this.age + " " + this.majorCode + "\n";
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
