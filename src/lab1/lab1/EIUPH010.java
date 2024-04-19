package lab1;

import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
public class EIUPH010 {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int number = reader.nextInt();
//		int[] myArr = new int[number];
//		for (int i = 0; i < number; i++) {
//			myArr[i] = reader.nextInt();
//		}
//		int maxOccValue = maxOccValue(myArr);
//		System.out.println(maxOccValue + " " + countExist(myArr, maxOccValue));
		int max_Val = Integer.MIN_VALUE;
		int max_Occ = 0;
		Hashtable<Integer, Integer> freqMap = new Hashtable<>();
		for (var i = 0; i < number; i++) {	
			var value = reader.nextInt();
			Integer count = freqMap.getOrDefault(value, 0);
			count++;
			freqMap.put(value, count);
			if (count > max_Occ) {
				max_Occ = count;
				max_Val = value;
			} else if (count == max_Occ && value < max_Val) {
				max_Val = value;
			}
		}
		System.out.println(max_Val + " " + max_Occ);
	}

	public static int maxOccValue(int[] myArr) {
		int maxCount = 0;
		int maxOccValue = 0;
		for (int i = 0; i < myArr.length; i++) {
			int count = countExist(myArr, myArr[i]);
			if (count > maxCount) {
				maxCount = count;
				maxOccValue = myArr[i];
			} else if (maxCount == count && myArr[i] < maxOccValue) {
				maxOccValue = myArr[i];
			}

		}
		return maxOccValue;
	}

	public static int countExist(int[] myArr, int number) {
		int countExist = 0;
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] == number) {
				countExist++;
			}
		}
		return countExist;
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