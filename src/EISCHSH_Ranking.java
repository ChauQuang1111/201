import java.util.*;
import java.io.*;

public class EISCHSH_Ranking {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		int best = reader.nextInt();
		List<Student> students = new ArrayList<>();
		while (number >= 1) {
			long id = reader.nextLong();
			String name = reader.next();
			int course = reader.nextInt();
			Student myStudent = new Student(id, name, course);
			for (int i = 0; i < course; i++) {
				int grade = reader.nextInt();
				myStudent.addGrade(grade);
			}
			students.add(myStudent);
			number--;
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = Long.compare(s1.id, s2.id);
			}
			return compare;
		});
		int rank = 0;
		int index = 0;
		StringBuffer myBuffer = new StringBuffer();
		while (index < students.size()) {
			//Khi 2 học sinh có điểm khác nhau thì thứ hạng mới đc cộng vô i.
			//vd: học sinh A (i = 0, 80đ); học sinh B (i = 1, 80đ); học sinh C (i = 2, 70đ)
			//học sinh A đương nhiên xếp thứ 1 (rank = 1)
			//xong xét đến i tiếp theo i = 1
			//học sinh B(i=1) vì gpa là 80 bằng với gpa của học sinh A(i-1=0) nên rank sẽ được giữ nguyên.
			//xét đến i = 2
			//lần này C tại i=2 có điểm = 70 khác với B(i=1) trước đó là 80 nên rank phải khác (rank = 2 + 1 = 3)
			if (index == 0 || students.get(index).gpa != students.get(index - 1).gpa) {
				rank = index + 1;
			}
			if (rank <= best) {
				myBuffer.append(rank).append(students.get(index).toString());
			}
			index++;
		}
		System.out.println(myBuffer);
		/*5 3
		1131209131 phung 1 60
		1131200010 phong 2 69 40
		1131200002 vinh 3 80 70 75
		1131200001 phuc 4 80 70 90 60
		1131200003 phuoc 4 80 70 90 59*/
		/*output:
		1 1131200001 phuc 75
		1 1131200002 vinh 75
		3 1131200003 phuoc 75*/
		 
	}

	static class Student {
		private long id;
		private String name;
		private int course;
		private double totalScore;
		private double credit;
		private double gpa;

		public Student(long id, String name, int course) {
			super();
			this.id = id;
			this.name = name;
			this.course = course;
		}

		public void addGrade(int grade) {
			if (grade < 50) {
				return;
			}
			this.totalScore += grade * 4;
			this.credit += 4;
			this.gpa = (double) totalScore / credit;
		}

		@Override
		public String toString() {
			return " " + this.id + " " + this.name + " " + Math.round(this.gpa) + "\n";
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
