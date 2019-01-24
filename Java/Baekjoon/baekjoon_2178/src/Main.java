import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		
		for (int r = 0;r<N;++r) {
			for (int c = 0; c<M;++c) {
				map[r][c] = sc.nextInt();
			}
		}
		
	}

}
