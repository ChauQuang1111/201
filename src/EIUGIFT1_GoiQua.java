import java.util.*;
import java.io.*;

public class EIUGIFT1_GoiQua {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num_gift = reader.nextInt();
		int num_paper = reader.nextInt();
		// Khai báo kích thước của gói quà
		List<Double> gifts = new ArrayList<>();
		while (num_gift >= 1) {
			double size_gift = reader.nextDouble();
			gifts.add(size_gift);
			num_gift--;
		}
		Collections.sort(gifts);
		// Khai báo kích thước của giấy gói
		List<Double> papers = new ArrayList<>();
		while (num_paper >= 1) {
			double size_paper = reader.nextDouble();
			papers.add(size_paper);
			num_paper--;
		}
		Collections.sort(papers);

		int total = 0;
		int index_gift = 0;
		int index_paper = 0;
		while (index_gift < gifts.size()) {
			if (index_paper < papers.size()) {
				// Tỷ lệ của Giấy gói và Gói quà
				double temp = (papers.get(index_paper) / gifts.get(index_gift));
				// Giấy gói = 2/3 * Gói quà <=> 3 * Giấy gói = 2 * Gói quà
				if (temp >= 2 && temp <= 3) {
					index_gift++;
					index_paper++;
					total++;
				} else {
					// temp < 2 : Giấy gói quá bé, phải tìm giấy gói lớn hơn.
					if (temp < 2) {
						index_paper++;
					}
					// temp > 3 : Giấy gói quá lớn, phải tìm gói quà khác vừa hơn.
					if (temp > 3) {
						index_gift++;
					}
				}
			} else {
				break;
			}
		}
		System.out.println(total);
		// Bài này hiểu đơn giản là nếu trúng tỷ lệ 2/3 ~= 0.6667 thì được 1 gói quà hoàn chỉnh.
		/* 4 4
		   2 3 2 4 
		   5 10 15 20*/
		//output: 2
		
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
