import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

class StockMarket {

	public static void main(String[] args) {
		int n = ni(), output = ni();
		HashMap<String, Shares> map = new HashMap<String, Shares>();
		ArrayList<Shares> shares = new ArrayList<>();
		String code, command;
		double amount, money;
		Shares myShares;
		for (int i = 0; i < n; i++) {
			command = ns();
			code = ns();
			amount = nd();
			money = nd();
			if (map.containsKey(code)) {
				map.get(code).add(command, amount, money);
				continue;
			}
			myShares = new Shares(code);
			myShares.add(command, amount, money);
			map.put(code, myShares);
			shares.add(myShares);
		}
		shares.sort((s1, s2) -> {
			int compare = Double.compare(s2.profit, s1.profit);
			if (compare == 0) {
				compare = s1.code.compareTo(s2.code);
			}
			return compare;
		});
		if (output > shares.size()) {
			output = shares.size();
		}
		while (output > 0 && output < shares.size() && shares.get(output).profit == shares.get(output - 1).profit) {
			output--;
		}
		StringBuilder bd = new StringBuilder();
		for (int i = 0; i < output; i++) {
			bd.append(shares.get(i).toString() + "\n");
		}
		System.out.println(bd);
	}

	static class Shares {
		private String code;
		private double buy = 0;
		private double sell = 0;
		private double profit;

		public Shares(String code) {
			// TODO Auto-generated constructor stub
			this.code = code;
		}

		public void add(String command, double amount, double money) {
			if (command.equals("B")) {
				buy += amount * money;
			} else {
				sell += amount * money;
			}
			profit = sell * 0.998 - buy * 1.001;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.code + " " + Math.round(this.profit);
		}
	}

	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}