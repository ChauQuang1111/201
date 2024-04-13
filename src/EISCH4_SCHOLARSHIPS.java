import java.util.*;
import java.io.*;

public class EISCH4_SCHOLARSHIPS {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num_of_student = reader.nextInt();
		int num_of_best = reader.nextInt();
		int pass_credit = reader.nextInt();
		int pass_score = reader.nextInt();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < num_of_student; i++) {
			String name = reader.next();
			int course = reader.nextInt();
			Student myStudent = new Student(name);
			students.add(myStudent);
			for (int j = 0; j < course; j++) {
				double grade = reader.nextDouble();
				myStudent.addGrade(grade, pass_credit);
			}
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = s1.name.compareTo(s2.name);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		if (num_of_best >= num_of_student) {
			for (int i = 0; i < num_of_best; i++) {
				if (students.get(i).gpa >= pass_score) {
					myBuffer.append(students.get(i).toString());
				}
			}
		} else {
			for (int i = 0; i < num_of_best; i++) {
				if (students.get(i).gpa >= pass_score) {
					if (students.get(i).gpa > students.get(num_of_best).gpa) {
						myBuffer.append(students.get(i).toString());
					} else {
						break;
					}
				}
			}
		}
		System.out.println(myBuffer);
	}

	static class Student {
		private String name;
		private double total_score;
		private double total_credit;
		private double gpa;

		public Student(String name) {
			super();
			this.name = name;
		}

		public void addGrade(double grade, int pass_credit) {
			if (grade < 50) {
				return;
			}
			this.total_score += grade * 4;
			this.total_credit += 4;
			if (total_credit >= pass_credit) {
				this.gpa = this.total_score / this.total_credit;
			}
		}

		@Override
		public String toString() {
			return this.name + " " + this.gpa + "\n";
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
