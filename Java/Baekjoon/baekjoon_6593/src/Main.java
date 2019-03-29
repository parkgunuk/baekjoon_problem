import java.util.*;

public class Main {
	static int L,R,C;
	static int[][] dir = {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};
	static char[][][] building;
	static boolean[][][] visited;
	static int time;
	static Queue<int[]> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			
			if(L == 0 && R == 0 && C == 0) return;
			
			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			q = new LinkedList<int[]>();
			time = 0;
			
			for(int t = L-1; t>=0;--t) {
				String buf = sc.nextLine();
				for(int r = 0; r<R;++r) {
					char[] ch = sc.nextLine().toCharArray();
					for(int c = 0; c<C;++c) {
						building[t][r][c] = ch[c];
						
						if(building[t][r][c] == 'S') {
							int[] tmp = {t,r,c,0};
							visited[t][r][c] = true;
							q.add(tmp);
						}
					}
				}
			}
			
			BFS();
			
			if(time == 0) System.out.println("Trapped!");
			else System.out.println("Escaped in "+time+" minute(s).");
			
		}
	}
	static void BFS() { // r,c,t,½Ã°£
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			int h = tmp[0];
			int r = tmp[1];
			int c = tmp[2];
			int t = tmp[3];
			
			if(building[h][r][c] == 'E') {
				time = t;
			}
			
			for(int i = 0; i<6;++i) {
				int nh = h+dir[i][0];
				int nr = r+dir[i][1];
				int nc = c+dir[i][2];
				
				if(0<=nr && nr<R && 0<=nc && nc<C && 0<=nh && nh<L && !visited[nh][nr][nc] && building[nh][nr][nc] != '#') {
					
					visited[nh][nr][nc] = true;
					int[] tmp1 = {nh,nr,nc,t+1};
					q.add(tmp1);
				}
				
			}
		}
	}
}
