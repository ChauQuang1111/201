import java.util.*;
import java.io.*;

public class EIUFISH_Management {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int number = reader.nextInt();
		int id_num = reader.nextInt();
		//HashMap bao gồm 2 phần: Key vs giá trị của nó
		HashMap<Integer, Integer> checkTask = new HashMap<>();
		while (number >= 1) {
			int id = reader.nextInt();
			int task = reader.nextInt();
			//id là key và task là giá trị
			checkTask.put(id, task);
			//map.put tương tự ArrayList.add
			number--;
		}
		StringBuffer myBuffer = new StringBuffer();
		while (id_num >= 1) {
			int id_check = reader.nextInt();
			//containsKey để kiểm tra xem trong HashMap có chứa cái id đó ko
			/* vd: 1 3
			 * 	   2 4
			 * 	   3 6
			 */
			//khi bấm checkTask.containsKey(1) thì là true, (2) là true, nhưng (4) sẽ là false
			if (checkTask.containsKey(id_check)) {
				myBuffer.append(checkTask.get(id_check)).append("\n");
				//checkTask.get(id_check) là để lấy giá trị của id ra
				//giá trị trả ra của  1 là 3,
			}
			id_num--;
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
