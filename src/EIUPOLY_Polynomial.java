import java.util.*;
import java.io.*;

public class EIUPOLY_Polynomial {

    public static void main(String[] args) {
        InputReader myReader = new InputReader(System.in);
        int test = myReader.nextInt();
        while(test >= 1) {
            int n = myReader.nextInt();
            double x = myReader.nextDouble();
            double[] arr = new double[n + 1];
            double res = 0;
            for (int i = n; i >= 0; i--) {
                arr[i] = myReader.nextDouble();
                res += arr[i] * Math.pow(x, i);
            }
            System.out.println(res);
            test--;
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

