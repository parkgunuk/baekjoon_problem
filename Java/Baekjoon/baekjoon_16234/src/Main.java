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
		go();
		System.out.println(total);
	}
	static void go() {
		while(true) {
			visited = new boolean[N][N];
			Bvisited = new boolean[N][N];
			q.clear();
			
			for(int r = 0;r<N;++r) {
				for(int c = 0;c<N;++c) {
					for(int i = 0;i<4;++i) {
						int nr = r+dir[i][0];
						int nc = c+dir[i][1];
						
						if(0<=nr && nr <N && 0<=nc && nc <N && !visited[nr][nc]) {
							int d = Math.abs(map[r][c] - map[nr][nc]);
							if(L<= d && d<=R) visited[nr][nc] = true;
						}
					}
				}
			}
			for(int r =0;r<N;++r) {
				for(int c = 0;c<N;++c) {
					if(visited[r][c] && !Bvisited[r][c]) {
						Bvisited[r][c] = true;
						int[] tmp = {r,c};
						q.add(tmp);
						BFS();
						w.add(tmp);
						fill();
					}
				}
			}
			
			if(count(visited)) {
				return;
			}
		}
		
	}
	static boolean count(boolean[][] a) {
		for(int r = 0; r<a.length;++r) {
			for(int c = 0; c<a[r].length;++c) {
				if(a[r][c]) return false;
			}
		}
		return true;
	}
	static void BFS() {
		int sum = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i = 0; i<4;++i) {
				int nr = tmp[0] + dir[i][0];
				int nc = tmp[1] + dir[i][1];
				
				if(0<=nr && nr <N && 0<=nc && nc <N && visited[nr][nc] && !Bvisited[nr][nc]) {
					Bvisited[nr][nc] = true;
					int[] t = {nr,nc};
					q.add(t);
				}
			}
			sum+=map[tmp[0]][tmp[1]];
			cnt++;
		}
		res = sum/cnt;
	}
	static void fill() {
		while(!w.isEmpty()) {
			int[] tmp = w.poll();
			
			for(int i = 0; i<4;++i) {
				int nr = tmp[0] + dir[i][0];
				int nc = tmp[1] + dir[i][1];
				
				if(0<=nr && nr <N && 0<=nc && nc <N && visited[nr][nc] && Bvisited[nr][nc] && map[tmp[0]][tmp[1]] != res) {
					int[] t = {nr,nc};
					w.add(t);
				}
			}
			map[tmp[0]][tmp[1]] = res;
			
		}
		total++;
	}
}
