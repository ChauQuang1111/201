package lab1;

import java.util.*;
import java.io.*;

public class EIUGRDSA2 {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		var noOfStudents = reader.nextInt();
		var noOfProblems = reader.nextInt();
		var noOfSubmissions = reader.nextInt();

		HashMap<Integer, Student> map = new HashMap<>();

		for (int i = 0; i < noOfStudents; i++) {
			var studentCode = reader.nextInt();
			Student student = new Student(studentCode);
			map.put(studentCode, student);

		}
		var code = new int[noOfProblems];
		for (int j = 0; j < noOfProblems; j++) {
			code[j] = reader.nextInt();
		}

		for (int k = 0; k < noOfSubmissions; k++) {
			var studentCode = reader.nextInt();
			var problemCode = reader.nextInt();
			var grade = reader.nextInt();
			for (var i = 0; i < code.length; i++) {
				if (problemCode == code[i]) {
					Student student = map.get(studentCode);
					student.addGrade(problemCode, grade, noOfProblems);
					map.put(studentCode, student);
				}
			}

		}
		var values = map.values();
		ArrayList<Student> list = new ArrayList<>(values);

		Collections.sort(list, (s1, s2) -> {
			int cp = Double.compare(s2.average, s1.average);
			if (cp == 0) {
				cp = Integer.compare(s1.totalProblem, s2.totalProblem);
			}
			if (cp == 0) {
				cp = Integer.compare(s1.id, s2.id);
			}
			return cp;
		});
		for (var i = 0; i < list.size(); i++) {
			sb.append(list.get(i).id).append(" ").append((int) list.get(i).average).append(" ")
					.append(list.get(i).totalProblem).append("\n");
		}
//		for (Student student : list) {
//			sb.append(student.toString()).append("\n");
//		}
		System.out.println(sb);

	}

	static class Student {
		public int id;
		public int totalGrade;
		public int totalProblem;
		public double average;
		HashMap<Integer, Integer> grades = new HashMap<Integer, Integer>();

		public Student(int id) {
			this.id = id;
		}

		public void addGrade(int problemCode, int grade, int numberOfProblems) {
			Integer oldGrade = grades.get(problemCode);

			if (oldGrade == null) {
				grades.put(problemCode, grade);
				totalGrade += grade;
				totalProblem++;
			} else if (oldGrade < grade) {
				totalGrade -= oldGrade;
				totalGrade += grade;
				grades.put(problemCode, grade);
				totalProblem++;
			} else {
				totalProblem++;
			}

			this.average = totalGrade / numberOfProblems;
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