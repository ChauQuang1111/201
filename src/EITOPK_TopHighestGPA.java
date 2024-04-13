import java.util.*;
import java.io.*;

public class EITOPK_TopHighestGPA {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num = reader.nextInt();
		int num_of_students = num;
		int best = reader.nextInt();
		List<Student> students = new ArrayList<>();
		while(num >= 1) {
			String name = reader.next();
			int course = reader.nextInt();
			Student myStudent = new Student(name, course);
			for (int i = 0; i < course; i++) {
				int grade = reader.nextInt();
				myStudent.addGrade(grade);
			}
			students.add(myStudent);
			num--;
		}
		students.sort((s1, s2) -> {
			int compare = Double.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = Integer.compare(s2.credit, s1.credit);
			}
			if (compare == 0) {
				compare = s1.name.compareTo(s2.name);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		if (best >= num_of_students) {
			for (int i = 0; i < best; i++) {
				myBuffer.append(students.get(i).toString());
			}
		} else {
			for (int i = 0; i < best; i++) {
				if (students.get(i).gpa > students.get(best).gpa) {
					myBuffer.append(students.get(i).toString());
				} else {
					break;
				}
			}
		}		
		System.out.println(myBuffer);
	}
	static class Student{
		private String name;
		private int course;
		private int credit = 0;
		private double total_score = 0;
		private double gpa = 0;
		public Student(String name, int course) {
			super();
			this.name = name;
			this.course = course;
		}
		public void addGrade(int grade) {
			if (grade < 50) {
				return;
			}
			this.total_score += grade * 4;
			this.credit += 4;
			this.gpa = (double) total_score / credit;
		}
		@Override
		public String toString() {
			return this.name + " " + Math.round(this.gpa) + " " + this.credit + "\n";
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
