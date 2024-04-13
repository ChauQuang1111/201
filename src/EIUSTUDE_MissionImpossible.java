import java.util.*;
import java.io.*;

public class EIUSTUDE_MissionImpossible {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) throws IOException {
        List<FullName> fullNames = new ArrayList<>();       
        int number = reader.nextInt();
        while (number >= 1) {
            String full_name = reader.nextLine();
            int first_space = full_name.indexOf(" ");
            int last_space = full_name.lastIndexOf(" ");
            String last_name = full_name.substring(0, first_space);
            String first_name = full_name.substring(last_space + 1);
            String mid_name = "";
            if (first_space == last_space) {
                mid_name = "";
            } else {
                mid_name = full_name.substring(first_space + 1, last_space);
            }
            FullName myName = new FullName(first_name, mid_name, last_name);
            fullNames.add(myName);
            number--;
        }
        fullNames.sort((n1, n2) -> {
            int compare = n1.first_name.compareTo(n2.first_name);
            if (compare == 0) {
                compare = n1.last_name.compareTo(n2.last_name);
            }
            if (compare == 0) {
                compare = n1.mid_name.compareTo(n2.mid_name);
            }
            return compare;
        });
        StringBuffer myBuffer = new StringBuffer();
        for (FullName fullName : fullNames) {
            myBuffer.append(fullName.toString());
        }
        System.out.println(myBuffer);
    }

    static class FullName {
        private String first_name;
        private String mid_name;
        private String last_name;

        public FullName(String first_name, String mid_name, String last_name) {
            super();
            this.first_name = first_name;
            this.mid_name = mid_name;
            this.last_name = last_name;
        }

        @Override
        public String toString() {
            return this.last_name + " " + this.mid_name + " " + this.first_name + "\n";
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

