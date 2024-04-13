import java.util.*;
import java.io.*;

public class EICREDI2_GPA {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int number = reader.nextInt();
        List<Student> students = new ArrayList<>();;
        StringBuffer myBuffer = new StringBuffer();
        while (number >= 1) {
            String name = reader.next();
            int course = reader.nextInt();
            Integer[] score = new Integer[course];
            for (int i = 0; i < score.length; i++) {
                score[i] = reader.nextInt();
            }
            Student myStudent = new Student(name, course, score);
            students.add(myStudent);
            number--;
        }
                        
        for (Student stu : students) {
            myBuffer.append(stu.name).append(" ");
            for (int scoreCheck : stu.score) {
                if (scoreCheck >= 50) {
                    myBuffer.append(scoreCheck).append(" ");
                }
            }
            myBuffer.append((int) stu.addScore()).append("\n");
        }
        System.out.println(myBuffer);

    }

    static class Student {
        private String name;
        private int course;
        private Integer[] score;

        public Student(String name, int course, Integer[] score) {
            this.name = name;
            this.course = course;
            this.score = score;
        }

        public double addScore() {
            double passScore = 0;
            double count = 0;
            for (int i = 0; i < score.length; i++) {
                if (score[i] >= 50) {
                    passScore += score[i];
                    count++;
                }
            }
            return (double) passScore / count;
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

