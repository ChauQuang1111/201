import java.util.*;
import java.io.*;

public class EIUSLS_Scholarships {
	
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		List<Student> students = new ArrayList<>();
		while (number >= 1) {
			String name = reader.next();
			int course = reader.nextInt();
			Student myStudent= new Student(name, course);
			for (int i = 0; i < course; i++) {
				int grade = reader.nextInt();
				myStudent.addGrade(grade);
			}
			students.add(myStudent);
			number--;
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			return compare;
		});	

		//chi xuat ra duy nhat 2 hoc sinh gioi nhat
		StringBuffer myBuffer = new StringBuffer();
		int best = 2;
		for (Student stu : students) {
			myBuffer.append(stu.toString());
			best--;
			if (best == 0) {
				break;
			}
		}
		System.out.println(myBuffer);
	}
	
	static class Student{
		private String name;
		private int course;
		private int totalScore;
		private double gpa;
		
		public Student(String name, int course) {
			super();
			this.name = name;
			this.course = course;
		}
		
		public void addGrade(int grade) {
			this.totalScore += grade;
			this.gpa = (double) totalScore / course;
		}

		@Override
		public String toString() {
			return this.name + "\n";
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
