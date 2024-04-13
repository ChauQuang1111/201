import java.util.*;
import java.io.*;

public class EIUMEDIAN2_Median {

    public static void main(String[] args) {
        InputReader myReader = new InputReader(System.in);
        int n = myReader.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = myReader.nextInt();
        }
        Arrays.sort(arr);
        double result = 0;
        if (arr.length % 2 == 1) {
            result = arr[arr.length / 2];
            System.out.println(Math.round(result));
        } else {
            int mid_1 = n / 2 - 1;
            int mid_2 = n / 2;
            result = (double) (arr[mid_1] + arr[mid_2]) / 2;
            System.out.println(result);
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

