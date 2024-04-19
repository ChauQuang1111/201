package lab1;

import java.util.*;
import java.io.*;

public class EIUGRADE {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {

		var n = reader.nextInt();
		var p = reader.nextInt();
		var m = reader.nextInt();

		var studentIds = new int[n];
		for (var i = 0; i < n; i++) {
			studentIds[i] = reader.nextInt();
		}

		var exerciseIds = new int[p];
		for (var i = 0; i < p; i++) {
			exerciseIds[i] = reader.nextInt();
		}

		Map<Integer, Student> studentMap = new HashMap<>();
		var submissions = new ArrayList<Submission>();

		for (var i = 0; i < m; i++) {
			var studentId = reader.nextInt();
			var exerciseId = reader.nextInt();
			var score = reader.nextInt();
			Submission submission = new Submission(studentId, exerciseId, score);
			submissions.add(submission);
		}

		for (var stuId : studentIds) {
			studentMap.put(stuId, new Student(stuId));
		}

		for (var exId : exerciseIds) {
			Map<Integer, Integer> scores = new HashMap<>();
			for (Submission submission : submissions) {
				if (submission.exerciseId == exId) {
					var studentId = submission.studentId;
					var score = submission.score;
					if (!scores.containsKey(studentId) || scores.get(studentId) < score) {
						scores.put(studentId, score);
					}
				}
			}
			for (var stuId : scores.keySet()) {
				var score = scores.get(stuId);
				Student student = studentMap.get(stuId);
				student.addGrade(score);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (var stuId : studentIds) {
			Student student = studentMap.get(stuId);
			var totalGrade = student.getTotalGrade();
			var avgGrade = totalGrade / exerciseIds.length;
			sb.append(stuId).append(" ").append(avgGrade).append("\n");

		}
		System.out.println(sb);
	}

	static class Submission {
		public int studentId;
		public int exerciseId;
		public int score;

		public Submission(int studentId, int exerciseId, int score) {
			this.studentId = studentId;
			this.exerciseId = exerciseId;
			this.score = score;
		}
	}

	static class Student {
		public int id;
		ArrayList<Integer> grades;

		public Student(int id) {
			this.id = id;
			grades = new ArrayList<>();
		}

		public void addGrade(int grade) {
			grades.add(grade);
		}

		public int getTotalGrade() {
			if (grades.isEmpty()) {
				return 0;
			}
			int sum = 0;
			for (int grade : grades) {
				sum += grade;
			}
			return sum;
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