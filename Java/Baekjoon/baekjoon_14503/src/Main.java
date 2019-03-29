import java.util.*;

public class Main {
	static int R,C,cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map=new int[R][C];
		visited=new boolean[R][C];
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		for(int rr =0;rr<R;++rr) {
			for(int cc = 0; cc<C;++cc) {
				map[rr][cc] = sc.nextInt();
			}
		}
		
		go(r,c,d);
		for(int rr = 0 ;rr<R;++rr) {
			for(int cc = 0; cc<C;++cc) {
				if(visited[rr][cc])
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	static void go(int r, int c, int d) {
		
		//1¹ø
		if(!visited[r][c])
			visited[r][c] = true;
		
		//2¹ø
		for(int i = 1;i<5;++i) {
			int di = (d+4-i)%4;
			int nr = r + dir[di][0];
			int nc = c + dir[di][1];
			
			if(0<=nr && nr<R&& 0<=nc && nc<C) {
				
				if(map[nr][nc] == 0 && !visited[nr][nc]) {
					go(nr,nc,di);
				}
			}

		}
		
		int nr = r +dir[(d+2)%4][0];
		int nc = c +dir[(d+2)%4][1];
		
		if(map[nr][nc] ==1)
			return;
		go(nr,nc,d);
	}
}

