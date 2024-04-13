import java.util.*;
import java.io.*;

public class EIUGRDSA2_TinhDiemMonHoc {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numStu = reader.nextInt(); // Student: số lượng SV
		int numSub = reader.nextInt(); // Subject: số lượng môn học
		int numAss = reader.nextInt(); // Assignment: số lần nộp bài
		ArrayList<Student> students = new ArrayList<>();
		// Map chứa id học sinh và dữ liệu của id đó
		HashMap<String, Student> mapStudent = new HashMap<>();
		/*
		 * Ta dùng 1 list và 3 maps: students, subjects, check_grade. 
		 * List đầu tiên để chứa Id sinh viên và in ra output.
		 * Map students để chứa id và thông tin sinh viên
		 * map subjects để chứa mã môn 
		 * Map subjects để ktra môn đó có tồn tại hay ko 
		 * Sau khi thỏa điều kiện từ map subjects, 
		 * thì map check_grade dùng để tính điểm
		 * để tính điểm cũng cần phải có id nên ta phải get id bằng map students
		 */
		String id = "";
		for (int i = 0; i < numStu; i++) {
			id = reader.next();
			Student myStudent = new Student(id);
			students.add(myStudent);
			mapStudent.put(id, myStudent);
		}
		//dùng Array cũng đc 100 nhưng bị chậm hơn HashMap.
		//String[] subjects = new String[numSub];
		HashMap<String, Boolean> subjects = new HashMap<>();
		String codeSub = "";
		for (int i = 0; i < numSub; i++) {
			codeSub = reader.next();
			subjects.put(codeSub, true);
			/*
			 * Vì cần phải lấy numSub cho phần giải sau nên k thể dùng: 
			 * while(numSub >= 1){
			 * ....... numSub--; } 
			 * vì cuối cùng kiểu gì numSub cũng bằng 0 
			 * Thay vào đó, ta cũng có thể dùng for
			 */
		}
		int grade = 0;
		for(int i = 0; i < numAss; i++) {
			id = reader.next();
			codeSub = reader.next();
			grade = reader.nextInt();
			if (subjects.containsKey(codeSub)) {
				Student checkStudent = mapStudent.get(id);
				checkStudent.addGrade(codeSub, grade, numSub);
			}
		}
		students.sort((s1, s2) -> {
			int compare = Long.compare(s2.gpa, s1.gpa);
			if (compare == 0) {
				compare = Integer.compare(s1.numAss, s2.numAss);
			}
			if (compare == 0) {
				compare = s1.id.compareTo(s2.id);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		students.forEach((s) -> {
			myBuffer.append(s.toString());
		});
		System.out.println(myBuffer);
	}

	static class Student {
		private String id;
		private int numAss = 0;
		private long total_score = 0;
		private long gpa = 0;
		HashMap<String, Integer> check_grade = new HashMap<String, Integer>();

		public Student(String id) {
			super();
			this.id = id;
		}

		/*
		 * HashMap này để kiểm tra điểm thông qua môn học Nếu môn này đã tồn tại trong
		 * map thì so sánh điểm cũ và điểm mới Vì đã tồn tại nên số lần nộp bài cũng
		 * phải cộng thêm 1.
		 */
		public void addGrade(String codeSub, int grade, int numSub) {
			if (check_grade.containsKey(codeSub) == true) {
				if (check_grade.get(codeSub) < grade) {
					// nếu điểm mới cao hơn thì trừ điểm cũ lấy điểm mới
					total_score = total_score - check_grade.get(codeSub) + grade;
					check_grade.put(codeSub, grade);
				}
			} else {
				// trường hợp code môn này k có trong danh sách thì add nó vô
				check_grade.put(codeSub, grade);
				total_score += grade;
			}
			this.numAss++; // số lần nộp thêm 1
			this.gpa =  this.total_score / numSub;
		}

		@Override
		public String toString() {
			return this.id + " " + this.gpa + " " + this.numAss + "\n";
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
