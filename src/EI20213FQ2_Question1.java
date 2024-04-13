import java.util.*;
import java.io.*;

public class EI20213FQ2_Question1 {

	static InputReader reader = new InputReader(System.in);
	
	public static void main(String[] args) {
		int number = reader.nextInt();
		//bài này chủ yếu là tính doanh thu từ mã sản phẩm (product_code)
		//nên không cần quan tâm mã giao dịch (trans_code)
		//Vì thế HashMap dùng để kiểm tra xem cái mã sản phẩm đó có tồn tại hay không
		HashMap<Long, Product> map_product = new HashMap<>();
		List<Product> products = new ArrayList<>(); //list dùng tuy dữ liệu là tất cả sản phẩm, nhưng do Hash map k tự sort đc nên cần ArrayList
		for (int i = 0; i < number; i++) {
			long trans_code = reader.nextLong();
			long product_code = reader.nextLong();
			double price = reader.nextDouble();
			double quantity = reader.nextDouble();
			//nếu nó chưa tồn tại thì ông add nó vào hash map
			if (map_product.containsKey(product_code) == false) {
				Product myProduct = new Product(trans_code, product_code);
				//ông nhập 5 nhưng thiệt chất trong ArrayList chỉ có 3 thôi (cái đầu tiên, cái thứ 2, và cái cuối cùng)
				// cái thứ 3, và 4 không add vào ArrayList (product_code của nó đã tồn tại rồi) -> xuống dòng else
				products.add(myProduct);
				map_product.put(product_code, myProduct);
				myProduct.calculation(product_code, price, quantity);				
			} else { //nhưng nếu nó tồn tại rồi thì thì lầy code_product đó ra để tính
				Product temp = map_product.get(product_code);
				temp.calculation(product_code, price, quantity);
			}
		}
		//add vào ArrayList vì HashMap không tự sort được
		products.sort((p1, p2) -> {
			int compare = Double.compare(p2.profit, p1.profit);
			if (compare == 0) {
				compare = Long.compare(p1.product_code, p2.product_code);
			}
			return compare;
		});
		StringBuffer myBuffer = new StringBuffer();
		for (Product pro : products) {
			myBuffer.append(pro.toString());
		}
		System.out.println(myBuffer);
	}
	
	static class Product{
		private long trans_code;
		private long product_code;
		private double total_price;
		private double total_quantity;
		private double profit;
		public Product(long trans_code, long product_code) {
			super();
			this.trans_code = trans_code;
			this.product_code = product_code;
		}
		public void calculation(long product_code, double price, double quantity) {
//			5
//			1111 1 1000 2
//			1112 2 100 1
//			1113 1 500 10
//			1114 2 99 1
//			1115 3 100 2
//			output:
//			1 583 = ((1000*2) + (500*10)) / 12
//			2 100
//			3 100
			this.total_price += price * quantity;
			this.total_quantity += quantity;
			this.profit = this.total_price / this.total_quantity;
		}
		@Override
		public String toString() {
			return this.product_code + " " + Math.round(this.profit) + "\n";
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
