import java.util.*;
import java.io.*;

public class EIWIFI_WIFI {

    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int number = reader.nextInt();
        double[] wifi = new double[number];
        StringBuffer myBuffer = new StringBuffer();
        for (int i = 0; i < wifi.length; i++) {
            double row = reader.nextDouble();
            double colum = reader.nextDouble();
            wifi[i] = Math.ceil((row - 2) / 3) * Math.ceil((colum - 2) / 3);
        }
        for (int i = 0; i < wifi.length; i++) {
            myBuffer.append((long) wifi[i]).append("\n");
        }
        System.out.println(myBuffer);
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

