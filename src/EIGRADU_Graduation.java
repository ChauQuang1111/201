import java.util.*;
import java.io.*;

public class EIGRADU_Graduation {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		int number = reader.nextInt();
		int passCredit = reader.nextInt();
		while (number >= 1) {
			long id = reader.nextLong();
			String name = reader.next();
			int course = reader.nextInt();
			Integer[] score = new Integer[course];
			Student myStudent = new Student(id, name, course, score);
			for (int i = 0; i < course; i++) {
				int grade = reader.nextInt();
				myStudent.addGrade(grade);
			}
			if (myStudent.creadit >= passCredit) {
				students.add(myStudent);
			}
			number -= 1;
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = Long.compare(s1.id, s2.id);
				if (compare == 1) {
					
				}
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		for (Student stu : students) {
			myBuffer.append(stu.toString());
		}
		System.out.println(myBuffer);
	}

	static class Student {
		private long id;
		private String name;
		private int creadit;
		private int gpa;
		private int totalScore;
		private int course;
		private Integer[] score;

		public Student(long id, String name, int course, Integer[] score) {
			super();
			this.id = id;
			this.name = name;
			this.course = course;
			this.score = score;
		}

		public void addGrade(int grade) {
			if (grade < 50) {
				return;
			}		
			totalScore += grade *4;
			creadit += 4;
			this.gpa = totalScore / creadit;
		}

		@Override
		public String toString() {
			return this.id + " " + this.name + " " + Math.round(this.gpa) + "\n";
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
