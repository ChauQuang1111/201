import java.io.*;
import java.util.*;

public class EIBESTBeststudents_2 {

	static InputReader inputReader = new InputReader(System.in);

	public static void main(String[] args) {
		int numStudent = inputReader.nextInt();
		double max = 0;
		String[] nameofStudent = new String[numStudent];
		double[] numofScore = new double[numStudent];
		for (int i = 0; i < numStudent; i++) {
			nameofStudent[i] = inputReader.next();
			int course = inputReader.nextInt();
			double total = 0;
			int sumNumScore = course;
			for (int j = 0; j < course; j++) {
				int score = inputReader.nextInt();
				sumNumScore -= score < 50 ? 1 : 0;
				total += score >= 50 ? score : 0;
			}
			numofScore[i] = sumNumScore != 0 ? (total / sumNumScore) : 0;
			max = Math.max(numofScore[i], max);
		}
		for (int i = 0; i < numofScore.length; i++) {
			if (max == numofScore[i]) {
				System.out.println(nameofStudent[i] + " " + (int) numofScore[i]);
			}
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

		public boolean hasNext() throws IOException {
			if (tokenizer != null && tokenizer.hasMoreTokens()) {
				return true;
			}
			temp = reader.readLine();
			return (temp != null && temp.length() > 0);
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

/*
 * input 
 */