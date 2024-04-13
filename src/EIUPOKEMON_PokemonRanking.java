import java.util.*;
import java.io.*;

public class EIUPOKEMON_PokemonRanking {
	
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int num = reader.nextInt();
		List<Pokemon> pokemons = new ArrayList<>();
		while(num >= 1) {
			long id = reader.nextLong();
			String name = reader.next();
			int attack = reader.nextInt();
			int defense = reader.nextInt();
			int agility = reader.nextInt();
			int luck = reader.nextInt();
			Pokemon myPokemon = new Pokemon(id, name, attack, defense, agility, luck);
			myPokemon.calculation(attack, defense, agility, luck);
			pokemons.add(myPokemon);
			num--;
		}
		pokemons.sort((p1, p2) -> {
			int compare = Double.compare(p2.power, p1.power);
			if (compare == 0) {
				compare = Integer.compare(p2.attack, p1.attack);
			}
			if (compare == 0) {
				compare = Long.compare(p1.id, p2.id);
			}
			return compare;
		});
		int rank = 1;
		double pre_power = 0;
		StringBuffer myBuffer = new StringBuffer();
		for (Pokemon p : pokemons) {
			if (p.power == pre_power) {
				myBuffer.append("-").append(p.toString());
				rank++;
				continue; //lenh nay se bo qua 3 lines duoi va tiep tuc vong lap
			}
			myBuffer.append(rank).append(p.toString());
			rank++;
			pre_power = p.power;
		}
		System.out.println(myBuffer);
	}
	static class Pokemon{
		private long id;
		private String name;
		private int attack;
		private int defense;
		private int agility;
		private int luck;
		private int total = 0;
		private double power = 0;
		
		public Pokemon(long id, String name, int attack, int defense, int agility, int luck) {
			super();
			this.id = id;
			this.name = name;
			this.attack = attack;
			this.defense = defense;
			this.agility = agility;
			this.luck = luck;
		}
		public void calculation(int attack, int defense, int agility, int luck) {
			this.total = attack + defense + agility + luck;
			this.power = (double) total / 4;
		}
		@Override
		public String toString() {
			return " " + this.id + " " + this.name + " " + Math.round(this.power) + "\n";
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
