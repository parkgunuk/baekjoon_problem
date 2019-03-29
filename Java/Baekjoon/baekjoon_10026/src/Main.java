import java.util.*;

public class Main {
	static int N;
	static boolean[][] visited;
	static char[][] map;
	static char[][] map1;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		String buf = sc.nextLine();
		map=new char[N][];
		map1=new char[N][];
		visited = new boolean[N][N];
		for(int i=0;i<N;++i) {
			map[i] = sc.nextLine().toCharArray();
			map1[i] = map[i];
			
		}
		int cnt = 0;
		int ccnt = 0;
		
		for(int r= 0;r<N;++r) {
			for(int c = 0;c<N;++c) {
				if(!visited[r][c]) {
					DFS(r,c, map[r][c]);
					cnt++;
				}
			}
		}
		visited = new boolean[N][N];
		for(int r =0;r<N;++r) {
			for(int c = 0;c<N;++c) {
				if(map[r][c] == 'R')
					map1[r][c] = 'G';
			}
		}
		for(int r= 0;r<N;++r) {
			for(int c = 0;c<N;++c) {
				if(!visited[r][c]) {
					DFS(r,c, map[r][c]);
					ccnt++;
				}
			}
		}
		System.out.println(cnt+" "+ccnt);
	}
	static void DFS(int r, int c, char ch) {
		
		visited[r][c] = true;
		
		for(int i = 0; i<4;++i) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			
			if(0<=nr && nr <N && 0<=nc && nc <N && map[nr][nc] == ch && !visited[nr][nc]) {
				DFS(nr,nc,ch);
			}
		}
	}
}
