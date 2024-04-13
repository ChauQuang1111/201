import java.util.*;
import java.io.*;

class EIBEST_BestStudents {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int num = reader.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String name = reader.next();
            int course = reader.nextInt();
            Student myStudent = new Student(name, course);
            for (int j = 0; j < course; j++) {
                int grade = reader.nextInt();
                myStudent.addGrade(grade);
            }
            students.add(myStudent);
        }
        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.gpa, s1.gpa);
            return compare;
        });
        StringBuffer myBuffer = new StringBuffer();
        for (int i = 0; i < students.size(); i++) {
            double best_score = students.get(0).gpa;
            if (students.get(i).gpa == best_score) {
                myBuffer.append(students.get(i).toString());
            } 
        }
        System.out.println(myBuffer);
    }

    static class Student {

        private String name;
        private int course;
        private double count = 0;
        private double total = 0;
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
            total += grade;
            count++;
            this.gpa = total / count;
            
        }

        @Override
        public String toString() {
            return this.name + " " + Math.round(gpa) + "\n";
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
