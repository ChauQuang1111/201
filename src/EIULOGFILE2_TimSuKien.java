import java.util.*;
import java.io.*;

public class EIULOGFILE2_TimSuKien {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num_log = reader.nextInt();
		int num_evt = reader.nextInt();
		long[] logfiles = new long[num_log];
		long[] events = new long[num_evt];
		for (int i = 0; i < logfiles.length; i++) {
			logfiles[i] = reader.nextLong();
		}
		Arrays.sort(logfiles);
		for (int i = 0; i < events.length; i++) {
			events[i] = reader.nextLong();
		}
		StringBuffer myBuffer = new StringBuffer();
		for (int i = 0; i < events.length; i++) {
			int index = Arrays.binarySearch(logfiles, events[i]);
			if (index < 0) {
				index = ~index; // -1 -> 1, -100 -> 100
			}
			if (index >= num_log) {
				myBuffer.append(-1);
			} else {
				myBuffer.append(logfiles[index]);
			}
			myBuffer.append(" ");
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
