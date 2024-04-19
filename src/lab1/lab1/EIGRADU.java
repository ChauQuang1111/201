package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIGRADU {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var students = new ArrayList<Student>();
		var nOfStudents = reader.nextInt();
		var minCredits = reader.nextInt();

		for (var i = 0; i < nOfStudents; i++) {
			var student_ID = reader.nextLong();
			var student_Name = reader.next();
			var nOfCourses = reader.nextInt();
			var totalMarks = 0;
			var totalCourses = 0;
			var nOfCredits = 0;

			for (var j = 0; j < nOfCourses; j++) {
				var mark = reader.nextInt();
				if (mark >= 50) {
					totalMarks += mark;
					nOfCredits += 4;
					totalCourses++;
				}
			}

			var GPA = (totalMarks / totalCourses);
			Student student = new Student(student_ID, student_Name, GPA);
			if (nOfCredits >= minCredits) {
				students.add(student);
			}
		}
		students.sort((s1, s2) -> {
			var ss = Integer.compare(s2.GPA, s1.GPA);
			if (ss == 0) {
				ss = Long.compare(s1.studentID, s2.studentID);
			}
			return ss;
		});
		StringBuilder sb = new StringBuilder();
		for (var stu : students) {
			sb.append(stu).append("\n");
		}
		System.out.println(sb);
	}

	static class Student {
		public long studentID;
		public String studentName;
		public int GPA;

		public Student(long studentID, String studentName, int GPA) {
			this.studentID = studentID;
			this.studentName = studentName;
			this.GPA = GPA;
		}

		@Override
		public String toString() {
			return studentID + " " + studentName + " " + GPA;
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
