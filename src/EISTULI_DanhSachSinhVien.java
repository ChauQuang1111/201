import java.util.*;
import java.io.*;

public class EISTULI_DanhSachSinhVien {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int number = reader.nextInt();
        int best = reader.nextInt();
        List<Student> students = new ArrayList<>();
        int j = 0;
        while (j < number) {
            long id = reader.nextLong();
            String name = reader.next();
            int course = reader.nextInt();
            Student myStudent = new Student(id, name, course);
            for (int i = 0; i < course; i++) {
                int grade = reader.nextInt();
                myStudent.addGrade(grade);
            }
            students.add(myStudent);
            j++;
        }
        
        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.gpa, s1.gpa);
            return compare;
        });
        
        StringBuffer myBuffer = new StringBuffer();
        if (best >= number) {
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

    static class Student {
        private long id;
        private String name;
        private int course;
        private double totalScore;
        private int credit;
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
            totalScore += grade * 4;
            credit += 4;
            this.gpa = totalScore / credit;
        }

        @Override
        public String toString() {
            return this.id + " " + this.name + " " + Math.round(this.gpa) + " " + this.credit + "\n";
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