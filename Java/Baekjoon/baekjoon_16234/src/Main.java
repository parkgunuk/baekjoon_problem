import java.util.*;

public class Main {
	static int N,L,R;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] Bvisited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<int[]> q = new LinkedList<>();
	static Queue<int[]> w = new LinkedList<>();
	static int res,total;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		L = sc.nextInt();
		R = sc.nextInt();
		
		for(int r = 0;r<N;++r) {
			for(int c = 0;c<N;++c) {
				map[r][c] = sc.nextInt();
			}
		}
	}
	
}
