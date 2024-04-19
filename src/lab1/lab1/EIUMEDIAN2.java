package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUMEDIAN2 {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
		int[] myArr = new int[number];
		for(int i = 0; i < number; i++) {
			myArr[i] = reader.nextInt();
		}
		System.out.println(median(myArr));
	}
	
	public static float median(int[] myArr) {
		Arrays.sort(myArr);
		if(myArr.length % 2 == 0) {
			return ( (float) myArr[myArr.length/2] + (float) myArr[myArr.length/2 - 1] ) / 2;
		}else {
			return (float) myArr[myArr.length / 2];
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