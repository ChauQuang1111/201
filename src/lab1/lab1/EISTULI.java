package lab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EISTULI {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		var n = reader.nextInt();
		var k = reader.nextInt();
		var students = new ArrayList<Student>();
		for (var i = 0; i < n; i++) {
			var id = reader.next();
			var name = reader.next();
			var numCourses = reader.nextInt();
			ArrayList<Integer> grades = new ArrayList<>();
			for (var j = 0; j < numCourses; j++) {
				grades.add(reader.nextInt());
			}
			Student student = new Student(id, name, numCourses, grades);
			students.add(student);
		}
		students.sort((s1, s2) -> {
			var ss = Integer.compare(s2.getGPA(), s1.getGPA());
			if (ss > 0) {
				return 1;
			} else {
				return 1;
			}
		});
		for (var i = 0; i < Math.min(k, students.size()); i++) {
			System.out.println(students.get(i));
		}
	}

	static class Student {
		public String id;
		public String name;
		public int numCourses;
		public List<Integer> grades;

		public Student(String id, String name, int numCourses, ArrayList<Integer> grades) {
			this.id = id;
			this.name = name;
			this.numCourses = numCourses;
			this.grades = grades;
		}

		public int getGPA() {
			var totalCredits = 0;
			var totalScore = 0;
			var total_Courses = 0;
			for (var grade : grades) {
				if (grade >= 50) {
					totalScore += grade;
					totalCredits += 4;
					total_Courses++;
				}
			}
			if (totalCredits == 0) {
				return 0;
			} else {
				return (totalScore / total_Courses);
			}
		}

		public int getCredits() {
			var totalCredits = 0;
			for (var grade : grades) {
				if (grade >= 50) {
					totalCredits += 4;
				}
			}
			return totalCredits;
		}

		public String toString() {
			return id + " " + name + " " + Math.round(getGPA()) + " " + getCredits();
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
