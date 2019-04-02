import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] copymap;
	static int[][] tmp;
	static int ans = Integer.MIN_VALUE;
	static int[][] dir = {{1,0},{-1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		copymap = new int[N][M];
		tmp = new int[N][M];
		
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<M;++c) {
				tmp[r][c] = map[r][c] = sc.nextInt();
			}
		}
		
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<M;++c) {
				if(tmp[r][c] == 0) {
					tmp[r][c] = 1;
					setWall(r,c,1);
					tmp[r][c] = 0;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	static void setWall(int r, int c, int cnt) {
		if(cnt == 3) {
			for(int rr = 0; rr<N;++rr) {
				copymap[rr] = tmp[rr].clone();
			}
			for(int rr = 0; rr<N;++rr) {
				for(int cc =0; cc<M;++cc) {
					if(copymap[rr][cc] == 2){
						virusGo(rr,cc);
					}
				}
			}
			safe();
		}
		else {
			for(int rr = 0; rr<N;++rr) {
				for(int cc = 0; cc<M;++cc) {
					if(tmp[rr][cc] == 0) {
						tmp[rr][cc] = 1;
						setWall(rr,cc,cnt+1);
						tmp[rr][cc] = 0;
					}
				}
			}
		}
		tmp[r][c] = 0;
		cnt--;
		
	}
	static void virusGo(int r, int c) {
		for(int i = 0 ;i<4;++i) {
			int rr = r+dir[i][0];
			int cc = c+dir[i][1];
			
			if(0<=rr&&rr<N&&0<=cc&&cc<M) {
				if(copymap[rr][cc] == 0) {
					copymap[rr][cc] = 9;
					virusGo(rr,cc);
				}
			}
		}
	}
	
	static void safe() {
		int cnt = 0;
		for(int i=0;i<N;++i) {
			for(int j = 0; j<M;++j) {
				if(copymap[i][j] == 0)
					cnt++;
			}
		}
		ans = Math.max(ans, cnt);
	}
}
