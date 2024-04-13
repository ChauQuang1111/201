import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EIDUPBOD_SameBirthday {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int number = reader.nextInt();
		List<LocalDate> birthdays = new ArrayList<>();
		while (number >= 1) {
			int day = reader.nextInt();
			int month = reader.nextInt();
			int year = reader.nextInt();
			LocalDate myLocalDate = LocalDate.of(year, month, day);
			//Tương tự như tạo đối tượng Birthday nhưng dùng kiểu dữ liệu LocalDate thì tiện hơn và giải quyết đc running-time.
			birthdays.add(myLocalDate);
			number--;
		}
		//lọc sinh nhật theo năm, tháng và ngày.
		Collections.sort(birthdays);
		//Nếu sử dụng LinkedHashMap thì dữ liệu được lọc mới đi theo HashMap
		HashMap<LocalDate, Integer> check_same = new LinkedHashMap<LocalDate, Integer>();
		int index = 0;
		while (index < birthdays.size()) {
				//Nếu ngày sinh đó chưa xuất hiện thì cho nó bằng 1
			if (check_same.containsKey(birthdays.get(index)) == false) {
				check_same.put(birthdays.get(index), 1);	
			} else {
				//Nếu trùng thì cộng nó thêm 1
				int same_count = check_same.get(birthdays.get(index));
				check_same.put(birthdays.get(index), same_count + 1);			
			}
			index++;
		}
		//Sử dụng DateTimeFormatter để khỏi làm cái điều kiện "0 + ngày/tháng" (nếu < 10)
		String pattern = "dd/MM/yyyy";
		DateTimeFormatter date_format = DateTimeFormatter.ofPattern(pattern);
		StringBuffer myBuffer = new StringBuffer();
		check_same.entrySet().forEach((dob) -> {
			myBuffer.append(dob.getKey().format(date_format)).append(" ").append(dob.getValue()).append("\n");
		});
		System.out.println(myBuffer);
		/*5
		10 3 1993
		15 2 1995
		15 2 1995
		10 2 1994
		10 3 1993*/
		/*output
		10/03/1993 2
		10/02/1994 1
		15/02/1995 2*/
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
