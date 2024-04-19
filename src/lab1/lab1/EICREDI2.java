package lab1;

import java.util.*;
import java.io.*;

public class EICREDI2 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var n = reader.nextInt();
		List<Student> students_List = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String name = reader.next();
			var courses = reader.nextInt();
			Student student = new Student(name);
			for (var j = 0; j < courses; j++) {
				var grade = reader.nextInt();
				student.addGrade(grade);
			}
			students_List.add(student);
		}

		students_List.sort((s1, s2) -> {
			var compare = Double.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = Double.compare(s1.gpa, s2.gpa);
			}
			return compare;
		});

		StringBuilder sb = new StringBuilder();
		if (students_List.size() < 2) {
			for (Student student : students_List.subList(0, 1)) {
				sb.append(student.name).append("\n").append(student.grades).append(" ").append(student.gpa);
			}
		} else {
			for (Student student : students_List.subList(0, 2)) {
				sb.append(student.name).append("\n").append(student.grades).append(" ").append(student.gpa);
			}
		}

		System.out.print(sb);

	}

	static class Student {

		public String name;
		public int courses;
		public double totalGrade;
		public double gpa;
		public ArrayList<Double> grades;

		public Student(String name) {
			this.name = name;
			grades = new ArrayList<>();
		}

		public void addGrade(double grade) {
			grades.add(grade);
			totalGrade += grade;
			gpa = totalGrade / grades.size();
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
