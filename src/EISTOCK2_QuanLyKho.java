import java.util.*;
import java.io.*;

public class EISTOCK2_QuanLyKho {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num = reader.nextInt();
		List<Inventory> inventories = new ArrayList<>();
		Hashtable<Integer, Inventory> mapCode = new Hashtable<>();
		while(num >= 1) {
			String type_trans = reader.next();
			int code = reader.nextInt();
			long quantity = reader.nextLong();
			long price = reader.nextLong();
			int time = reader.nextInt();
			if (mapCode.containsKey(code) == false) {
				if ("+".equals(type_trans) == true) {
					Inventory myInventory = new Inventory(code, time);			
					inventories.add(myInventory);
					mapCode.put(code, myInventory);
					myInventory.calculation(type_trans, quantity, price);
				}		
			} else {
				Inventory temp_inv = mapCode.get(code);
				temp_inv.calculation(type_trans, quantity, price);
			}		
			num--;
		}
		inventories.sort((i1, i2) -> {
			int compare = Integer.compare(i1.code, i2.code);
			return compare;
		});
		StringBuffer output = new StringBuffer();
		for (Inventory inv : inventories) {
			output.append(inv.toString());
		}
		System.out.println(output);
	}
	
	static class Inventory{
		private int code;
		private int time;
		private long num_import;
		private long total;
		private long avr;
		
		public Inventory(int code, int time) {
			super();
			this.code = code;
			this.time = time;
		}
		public void calculation(String type_trans, long quantity, long price) {
			if ("+".equals(type_trans) == true) {
				num_import += quantity;
				total += (quantity * price);
			} else {
				if (quantity > num_import) {
					return;
				}
				total -= (quantity * price);
				num_import -= quantity;
			}
			
			this.avr = total / num_import;
		}
		@Override
		public String toString() {
			return this.code + " " + this.num_import + " " + this.avr + " " + this.time + "\n";
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
