import java.util.*;
import java.io.*;

public class EIUBISEA_BinarySearch {
    
    static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
        int num = reader.nextInt();
        int num_key = reader.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < numbers.length; i++) {
			numbers[i] = reader.nextInt();
		}
        Arrays.sort(numbers);
        StringBuffer myBuffer = new StringBuffer();
        while (num_key >= 1) {
            int key = reader.nextInt();
            int result = binarySeach(numbers, key);
            myBuffer.append(result).append(" ");
            num_key--;
        }
        System.out.println(myBuffer);
    }
    public static int binarySeach (int[] numbers, int key) {
        return binary_search(numbers, key, 0, numbers.length);
    }
    static int binary_search (int[] numbers, int key, int from_index, int to_index) {
        if (from_index == to_index) {
            return -1;
        }
        int middle = (from_index + to_index) / 2;
        if (numbers[middle] == key) {
        	//trong trường hợp có 2 key cần tìm bằng nhau trong dãy 
        	//(VD: 1 2(i=1) 2(i=2) 3 ...) -> output = 1
        	//thì chỉ lấy số ở vị trí đầu tiên.
            while (middle >= 1) {
                if (numbers[middle - 1] == key) {
                    middle--;
                }
                else {
                    break;
                }    
            }
            return middle;
                       
        } else if (numbers[middle] < key) {
        	//nếu pt ở vị trí giữa mà bé hơn pt cần tìm thì bỏ 1 nửa dãy bé hơn đi
            //chỉ xét phần từ middle + 1 trở lên thôi
        	//vd cần tìm 10 trong dãy (1, 2, 4, 5, 7, 10, 18)
            //thì chỉ xét từ 7 đến 18 thôi, còn lại bỏ.
            return binary_search(numbers, key, middle + 1, to_index);
        } else {
        	//tương tự nếu phần tử ở giữa lớn hơn key, tức là key cần tìm nằm ở 1 nửa còn lại.
        	//VD: 1, 2, 4, 5, 7, 10, 18 mà cần tìm 2, middle lúc này là 5
        	//thì chỉ xét từ 1, 2, 4, 5 thôi, còn lại bỏ.
            return binary_search(numbers, key, from_index, middle);
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
