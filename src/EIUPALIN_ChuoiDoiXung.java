import java.util.*;
import java.io.*;

public class EIUPALIN_ChuoiDoiXung {
	
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException {
		int number = reader.nextInt();
		String input = "";
		StringBuilder myBuilder = new StringBuilder();
		while (number >= 1) {
			input = reader.nextLine();
			String opposite = "";
			int i = input.length() - 1;
			while (i >= 0) {
				opposite += input.charAt(i);
				i--;
			}
			if (input.equals(opposite) == true) {
				myBuilder.append("YES").append("\n");
			} else {
				myBuilder.append("NO").append("\n");
			}
			number--;
		}
		System.out.println(myBuilder);
		//Nếu 1 chữ đọc là xuôi hay ngược vẫn như nhau thì là đối xứng (VD: level, WCW, mem, aaa)
		//member != rebmem. Vậy member không phải chuỗi đối xứng
		//String.chartAt(i): Lấy giá trị (ký tự) của String tại vị trí i. Vd: level, i = 2 thì giá trị là "v"
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
