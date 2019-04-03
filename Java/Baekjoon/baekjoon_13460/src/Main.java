import java.util.*;
public class Main {
//TODO
	static int N,M;
	static char[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		String buf = sc.nextLine();
		map = new char[N][];
		visited = new boolean[N][M];
		
		for(int r = 0;r<N;++r)
			map[r] = sc.nextLine().toCharArray();
		
	}
	
}
