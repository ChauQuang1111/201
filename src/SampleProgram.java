import java.util.*;
import java.io.*;

/*
 * https://www.spoj.com/EIUDISC2/status/
 * https://codeforces.com/
 */
class SampleProgram {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt(), m = reader.nextInt();

		// Primitive types; wrapper types
		// int +=2*10^9, long +=1*10^18, char, float, double; Integer, Long, Character,
		// Float, Double
		Double.compare(0.1, (double) 10 / 100);
		// Utilities: Math, StringBuffer/StringBuilder, Arrays
		StringBuilder outBuffer = new StringBuilder();
		for (int i = 0; i < n; i++) {
			outBuffer.append(i + "\n");
		}
		System.out.println(outBuffer);

		Integer[] prices = new Integer[n];
		Arrays.sort(prices); // Sort increasing order

		// Sort descreasing order ???
		Arrays.sort(prices, (p1, p2) -> (p2 - p1));

		// Prebuilt Data Structures: List, ArrayList, ArrayList<T>, HashMap<K, V>,
		List<Long> weights = new ArrayList<Long>();
		for (long i = 0; i < n; i++) {
			weights.add(i);
			long weight = weights.get(0);
			weights.set(0, weight);
			System.out.println(weight);
		}

		// Stack, ArrayQueue
		// Dictionary
		// Algorithms: Sort, BinarySearch
		Comparator<Double> compareDouble = (n1, n2) -> n2.compareTo(n1);
		Double[] numbers = new Double[1000];
		Arrays.sort(numbers);
		Arrays.sort(numbers, 10, 100, compareDouble);
		Double key = 10d;
		Arrays.binarySearch(numbers, key, compareDouble);

		List<Integer> values = new ArrayList<Integer>();
		values.add(10);
		// values.indexOf(o)
		// 100000
		// 50K * 100K => 5B
		values.sort((n1, n2) -> n2.compareTo(n1));
		Collections.binarySearch(values, 10, (n1, n2) -> n2.compareTo(n1));

		HashMap<Integer, Boolean> map = new HashMap<>();
		map.put(10, true);
		map.get(10);
		map.containsKey(10);
		Dictionary<Integer, Boolean> dic = new Hashtable<Integer, Boolean>();

		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new ArrayDeque<>();

		StringBuffer outBf = new StringBuffer();
		for (int i = 0; i < n; i++) {
			outBf.append(i + "\n");
		}
		System.out.println(outBf);
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