import java.util.*;
import java.io.*;

public class EIUTRANS_Messages {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) throws IOException{
		int word_sent = reader.nextInt();
		int word_check = reader.nextInt();
		HashMap<String, String> check_word = new HashMap<>();
		
		while (word_check >= 1) {
			String language = reader.nextLine();
			String[] part = language.split(" ");
			//kiểm tra xem nếu phần nào ngắn hơn thì lấy nó làm GIÁ TRỊ, phần dài làm KEY
			if (part[0].length() > part[1].length()) {
				check_word.put(part[0], part[1]);
			}
			word_check--;
		}
		String original = reader.nextLine();
		String real = "";
		String[] part = original.split(" ");
		int i = 0;
		while (i < word_sent) {
			//Nếu trong MAP chưa có từ đó thì gắp nó vô luôn.
			if (check_word.get(part[i]) == null) {
				real = real.concat(part[i] + " ");
			} else {
				//Nếu có rồi thì lấy thằng ngắn hơn của nó thế vô.
				real = real.concat(check_word.get(part[i]) + " ");
			}
			i++;
		}
		//String.concat dùng để nối chuỗi (Giống append bên StringBuilder)
		System.out.println(real);
		/*5 3
		joll wuqrd
		euzf un
		hbnyiyc rsoqqveh
		hbnyiyc joll joll euzf*/
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
		
		public float nextFloat() {
			return Float.parseFloat(next());
		}
	}
}
