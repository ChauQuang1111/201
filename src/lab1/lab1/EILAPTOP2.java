package lab1;

import java.io.*;
import java.util.*;

public class EILAPTOP2 {


	public static void main(String[] args) {
		var n = ni();
		var laptops = new ArrayList<Laptop>();
		StringBuilder sb = new StringBuilder();
		for (var i = 0; i < n; i++) {
			var price = ni();
			var speed = ni();
			var laptop = new Laptop(price, speed);
			laptops.add(laptop);
		}
		boolean happyBeo = false;
		
		
		for (int i = 0; i < laptops.size(); i++) {
			for (int j = i + 1; j < laptops.size(); j++) {
				Laptop laptop1 = laptops.get(i);
				Laptop laptop2 = laptops.get(j);
				if (laptop1.isFasterAndCheaper(laptop2) || laptop1.isSlowerAndMoreExpensive(laptop2)) {
					happyBeo = true;
					break;
				}
			}
			if (happyBeo) {
				break;
			}
		}
		if (happyBeo) {
			sb.append("Happy Beo");
		} else {
			sb.append("Poor Beo");
		}
		System.out.println(sb);
	}

	static class Laptop {
		public int price;
		public int speed;

		public Laptop(int price, int speed) {
			this.price = price;
			this.speed = speed;
		}

		public boolean isFasterAndCheaper(Laptop other) {
			return this.speed > other.speed && this.price < other.price;
		}

		public boolean isSlowerAndMoreExpensive(Laptop other) {
			return this.speed < other.speed && this.price > other.price;
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
