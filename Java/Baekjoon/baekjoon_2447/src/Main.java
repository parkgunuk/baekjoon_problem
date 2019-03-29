import java.util.*;

public class Main {
	static String[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		map = new String[N][N];
		int K = 0;
		for(int i = 0;i<9;++i) {
			if(N == Math.pow(3, i)) {
				K = i;
				break;
			}
		}
		
		draw(K);
	}
	static void draw(int k) {
		for(int i =1;i<=k;++i) {
			
		}
	}
}
