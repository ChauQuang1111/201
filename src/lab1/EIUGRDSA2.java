package Week6;

import java.util.*;
import java.io.*;

class ExerciseGrades2 {
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		var studentMap = new HashMap<Integer, Student>();
		var nStudent = ni();
		var nExcersise = ni();
		var nSubmission = ni();
		var exerciseList = new ArrayList<Integer>();
		int studentID;
		int exerCode;

		for (var i = 0; i < nStudent; i++) {
			studentID = ni();
			studentMap.put(studentID, new Student(studentID, nExcersise));
		}

		for (var i = 0; i < nExcersise; i++) {
			exerCode = ni();
			exerciseList.add(exerCode);
		}

		for (var i = 0; i < nSubmission; i++) {
			studentID = ni();
			exerCode = ni();
			var grade = ni();

			if (exerciseList.contains(exerCode)) {
				var student = studentMap.get(studentID);
				student.updateGrade(exerCode, grade);
				studentMap.put(studentID, student);
			}
		}
		var studentList = new ArrayList<Student>(studentMap.values());

		studentList.sort((s1, s2) -> {
			var compare = Integer.compare(s2.avg, s1.avg);
			
			if (compare == 0) {
				compare = Integer.compare(s1.count, s2.count);
				if (compare == 0) {
					compare = Integer.compare(s1.id, s2.id);
				}
			}
			return compare;
		});

		for (var student : studentList) {
			output.append(student).append("\n");
		}
		System.out.println(output);
	}

	static class Student {
		public int id;
		public int nExercise;
		public HashMap<Integer, Integer> gradeMap = new HashMap<>();
		public int totalGrade;
		public int count;
		public int avg;

		public Student(int id, int nExercise) {
			this.id = id;
			this.nExercise = nExercise;
		}

		public void updateGrade(int exerCode, int score) {
			var grade = gradeMap.getOrDefault(exerCode, 0);

			if (score > grade) {
				totalGrade = totalGrade - grade + score;
				gradeMap.put(exerCode, score);
				avg = totalGrade / nExercise;
			}
			count++;
		}

		@Override
		public String toString() {
			return id + " " + avg + " " + count;
		}
	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}