import java.util.*;
import java.io.*;

public class EIUGRDSA_ExcerciseGrades {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numStu = reader.nextInt();
		int numPro = reader.nextInt();
		int numSub = reader.nextInt();
		List<Student> students = new ArrayList<>();
		HashMap<Integer, Student> mapStu = new HashMap<>();
		int id = 0;
		while (numStu >= 1) {
			id = reader.nextInt();
			Student myStudent = new Student(id);
			students.add(myStudent);
			mapStu.put(id, myStudent);
			numStu--;
		}
		String codeProb = "";
		HashMap<String, Boolean> subjects = new HashMap<>();
		for (int i = 0; i < numPro; i++) {
			codeProb = reader.next();
			subjects.put(codeProb, true);
		}
		int grade = 0;
		while (numSub >= 1) {
			id = reader.nextInt();
			codeProb = reader.next();
			grade = reader.nextInt();
			if (subjects.containsKey(codeProb) == true) {
				Student check_student = mapStu.get(id);
				check_student.addGrade(codeProb, grade, numPro);
			}
			numSub--;
		}
		students.sort((s1, s2) -> {
			int compare = Integer.compare(s1.id, s2.id);
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		for (Student stu : students) {
			myBuffer.append(stu.toString());
		}
		System.out.println(myBuffer);
	}
	static class Student{
		private int id;
		private long gpa;
		private long total_score = 0;
		HashMap<String, Integer> grades = new HashMap<String, Integer>();
		public Student(int id) {
			super();
			this.id = id;
		}
		public void addGrade(String codeProb, int grade, int numProb) {
			if (grades.containsKey(codeProb) == true) {
				if (grades.get(codeProb) < grade) {
					int old_score = grades.get(codeProb);
					total_score = total_score - old_score + grade;
					grades.put(codeProb, grade);
				}
			} else {
				grades.put(codeProb, grade);
				total_score += grade;
			}
			this.gpa = total_score / numProb;
		}
		@Override
		public String toString() {
			return this.id + " " + this.gpa + "\n";
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
        
        public byte nextByte() {
        	return Byte.parseByte(next());
        }
    }
}
