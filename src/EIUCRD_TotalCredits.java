import java.util.*;
import java.io.*;

public class EIUCRD_TotalCredits {
	
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		int number_2 = number;
		HashMap<String, Integer> mapSubject = new HashMap<>();
		while(number >= 1) {
			String id_subject = reader.next();
			int creadit = reader.nextInt();
			//Mã môn là key, tín chỉ của môn đó là giá trị
			mapSubject.put(id_subject, creadit);
			number--;
		}
		int total_creadit = 0;
		//lúc chạy xong vòng lặp đầu thì number lúc này bằng 0 rồi nên k dùng đc nữa
		while (number_2 >= 1) {
			int grade = reader.nextInt();
			String id_check = reader.next();
			//Môn đó phải có trong danh sách, và điểm từ 50 trở lên thì ms đậu
			//Đậu thì cộng tín chỉ của môn đó.
			if (mapSubject.containsKey(id_check) && grade >= 50) {
				total_creadit += mapSubject.get(id_check);
			}
			number_2--;
		}
		System.out.println(total_creadit);
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
