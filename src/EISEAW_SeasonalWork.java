import java.util.*;
import java.io.*;

public class EISEAW_SeasonalWork {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num = reader.nextInt();
		List<Employee> employees = new ArrayList<>();
		while (num >= 1) {
			String name = reader.next();
			long wage = reader.nextLong();
			int day = reader.nextInt();
			int[] hours = new int[day];
			int total_hours = 0;
			for (int i = 0; i < hours.length; i++) {
				hours[i] = reader.nextInt();
				total_hours += hours[i];
			}
			double income = calculation(wage, hours);
			Employee myEmployee = new Employee(name, wage, day, hours, total_hours, income);
			employees.add(myEmployee);
			num--;
		}
		employees.sort((e1, e2) -> {
			int compare = Double.compare(e1.income, e2.income);
			if (compare == 0) {
				compare = e1.name.compareTo(e2.name);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		for (Employee employee : employees) {
			myBuffer.append(employee.toString());
		}
		System.out.println(myBuffer);
	}

	static double calculation(long wage, int[] hours) {
		double income = 0;
		for (int i = 0; i < hours.length; i++) {
			income += wage * hours[i];
		}
		if (income >= 2000000) {
			income = (double) income * 0.9;
		}
		return income;
	}

	static class Employee {
		private String name;
		private long wage;
		private int day;
		private int[] hours;
		private int total_hours;
		private double income;

		public Employee(String name, long wage, int day, int[] hours, int total_hours, double income) {
			super();
			this.name = name;
			this.wage = wage;
			this.day = day;
			this.hours = hours;
			this.total_hours = total_hours;
			this.income = income;
		}

		@Override
		public String toString() {
			return this.name + " " + this.total_hours + " " + Math.round(this.income) + "\n";
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
