import java.util.*;
public class Main {

	static int N,M, ans;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	
	static int[][] other1 = {{-1,0},{0,-1},{0,1},{0,0}};
	static int[][] other2 = {{1,0},{-1,0},{0,1},{0,0}};
	static int[][] other3 = {{1,0},{0,-1},{0,1},{0,0}};
	static int[][] other4 = {{-1,0},{0,-1},{1,0},{0,0}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		ans = 0;
		
		map = new int[N][M];
		
		for(int r = 0;r<N;++r) {
			for(int c = 0; c<M;++c) {
				map[r][c] = sc.nextInt();
			}
		}
		visited = new boolean[N][M];
		for(int r = 0;r<N;++r) {
			for(int c = 0;c<M;++c) {
				DFS(r,c,0,0);
				visited[r][c] = false;
				other(r,c);
			}
		}
		
		System.out.println(ans);
	}
	static void DFS(int r,int c,int cnt, int sum) {
		visited[r][c] = true;
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		for(int i = 0 ; i<4;++i) {
			int nr = r+dir[i][0];
			int nc = c+dir[i][1];
			
			if(0<=nr && nr<N && 0<=nc && nc< M && !visited[nr][nc]){
				DFS(nr,nc,cnt+1,sum+map[r][c]);
				visited[nr][nc] = false;
			}
			
		}
	}
	
	static void other(int r, int c) {
		int sol1 = 0;
		int sol2 = 0;
		int sol3 = 0;
		int sol4 = 0;
		
		if (r+1 < N && c + 1< M && c - 1 >= 0)
			sol1 = Math.max(sol1, map[r][c]+map[r+1][c]+map[r][c+1]+map[r][c-1]);
		if(r+1 < N && r - 1 >= 0 && c - 1 >= 0)
			sol2 = Math.max(sol2, map[r][c]+map[r+1][c]+map[r-1][c]+map[r][c-1]);
		if (r-1 >= 0 && r + 1< N && c + 1 < M)
			sol3 = Math.max(sol3, map[r][c]+map[r-1][c]+map[r+1][c]+map[r][c+1]);
		if (c-1 >= 0 && c + 1< M && r - 1 >= 0)
			sol4 = Math.max(sol4, map[r][c]+map[r][c-1]+map[r][c+1]+map[r-1][c]);
		
		ans = Math.max(ans, sol1);
		ans = Math.max(ans, sol2);
		ans = Math.max(ans, sol3);
		ans = Math.max(ans, sol4);
		
	}
}
