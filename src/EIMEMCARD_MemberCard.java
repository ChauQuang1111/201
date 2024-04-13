import java.util.*;
import java.io.*;

public class EIMEMCARD_MemberCard {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int number = reader.nextInt();
		long[] purchases = {1000000, 20000000, 50000000, 200000000, Long.MAX_VALUE};
		double[] sales = {0.02, 0.03, 0.05, 0.07};
		long total = 0;
		StringBuffer myBuffer = new StringBuffer();
		while(number >= 1) {
			long pay = reader.nextLong();
			double discount = 0;
			for (int i = 0; i < sales.length; i++) {
				if (total >= purchases[i] && total < purchases[i+1]) {
					discount = (double) pay * sales[i];
					break;
				}				
			}
			total += pay;
			myBuffer.append(discount + " ");
			number--;
		}
		System.out.println(myBuffer);
		//discount của lần mua này dựa trên total trước đó.
		/*Input:
			5
			500000 2000000 6000000 50000000 3000000
		Output:
			0 0 120000 1000000 150000*/
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
