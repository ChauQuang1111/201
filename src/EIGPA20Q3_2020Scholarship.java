import java.util.*;
import java.io.*;

class EIGPA20Q3_2020Scholarship {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int num = reader.nextInt();
        int best = reader.nextInt();
        TreeMap<Long, Student> map_stu = new TreeMap<>();
        while (num >= 1) {
            long id = reader.nextLong();
            String code = reader.next();
            int grade = reader.nextInt();
            if (map_stu.containsKey(id) == false) {
                Student newStu = new Student(id);
                map_stu.put(id, newStu);
            }
            Student temp = map_stu.get(id);
            temp.addGrade(grade, code);
            num--;
        }
        List<Student> students = new ArrayList<>(map_stu.values());
        students.sort((s1, s2) -> {
            int compare = Double.compare(s2.gpa, s1.gpa);
            if (compare == 0) {
                compare = Long.compare(s1.id, s2.id);
            }
            return compare;
        });
        StringBuffer myBuffer = new StringBuffer();
        int rank = 1;
        int index = 0;
        while (index < best) {
            if (index > 0 && students.get(index).gpa != students.get(index - 1).gpa) {
                rank = index + 1;
            }
            myBuffer.append(rank).append(students.get(index).toString());
            
            index++;
        }
        System.out.println(myBuffer);
    }

    static class Student {

        private long id;
        private double total = 0;
        private double gpa = 0;
        private double count = 0;
        HashMap<String, Integer> grades = new HashMap<>();

        public Student(Long id) {
            super();
            this.id = id;
        }

        public void addGrade(int grade, String code) {
            if (grades.containsKey(code) == true) {

                if (grades.get(code) < grade) {
                    int old = grades.get(code);
                    total = total - old + grade;
                    grades.put(code, grade);
                }
            } else {
                grades.put(code, grade);
                total += grade;

            }
            calAvr(grade);
        }

        private void calAvr(int grade) {
            if (grade < 50) {
                return;
            }
            count++;
            gpa = (double) total / grades.size();
        }

        @Override
        public String toString() {
            return " " + this.id + " " + (int)(this.gpa) + "\n";
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

//PVfBVwURwNnuUjJbQ7hyoqnh1PJyDhiNV9nDofCjOmRajELjEcMqhHBYcVxzcVeRH5dkzYNCG/H76xcGzZiSaDG4pbnC9hwmideHrqelOL4bAJmkqMkehZ8Co2yqaf4XT7lBYT8Uhyuh0UgqaNfAWV7om8BXTBD669ZOlitZaXU80g+Dcfo15d3rdtKoOiCd5G+sw3qkSggW8VPAQc9NZGK2/fParEEsMkKQC/fICveHY/UmWXKtxJ44a9EVgn0+YjZwL+88bCsvagkwziRrCOcNbwLRJx/gcvmrX1gT7Xt21oETXfRYCw6YmfL2pMTKw11GlfjGhrdGQGh/efxAK1r4oJlmhFzOdWay/95SGNl5dxylS/fPaob1Qil4n0AGx1VKwZTouk0zDgNR6DmHzWwmEkGSAXicQBYCjeAS70yCw3U0DHMeyxVj4SqjwMLoU50ISctEF/F4ej0RPPGYHudByQQlQuTrStiQZA5ejxkznXnG8ETqyE70JF0zhWd20goWidnGueYGtp3Dl0+SSJIrfOStk9PUfRApAsODbw8=