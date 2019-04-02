import java.util.*;
public class Main {
//TODO
	static int N,M;
	static char[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	static Queue<int[]> Rq;
	static Queue<int[]> Bq;
	static int Rcnt , Bcnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		String buf = sc.nextLine();
		map = new char[N][];
		visited = new boolean[N][M];
		Rcnt = 0;
		Bcnt = 0;
		Rq = new LinkedList<>();
		Bq = new LinkedList<>();
		for(int r = 0;r<N;++r)
			map[r] = sc.nextLine().toCharArray();
		
		for(int r = 0;r<N;++r) {
			for(int c = 0; c<M;++c) {
				if(map[r][c] == 'R') {
					visited[r][c] = true;
					int[] tmp = {r,c,0};
					Rq.add(tmp);
				}
				else if(map[r][c] == 'B') {
					visited[r][c] = true;
					int[] tmp = {r,c,0};
					Bq.add(tmp);
				}
			}
		}
		BFS();
		if(Bcnt <= Rcnt) Rcnt =-1;
		System.out.println(Rcnt);
	}
	static void BFS() {
		
		while(!Rq.isEmpty()) {
			int[] Rtmp = Rq.poll();
			int[] Btmp;
			if(Bq.isEmpty())
				
			Btmp = Bq.poll();
			
			if(Rtmp[2]>=10) {
				Rcnt = -1;
				return;
			}
			
			for(int i = 0; i<4;++i) {
				int Rnr = Rtmp[0] + dir[i][0];
				int Rnc = Rtmp[1] + dir[i][1];
				
				int Bnr = Btmp[0] + dir[i][0];
				int Bnc = Btmp[1] + dir[i][1];
				
				
				if((map[Rnr][Rnc] == '.' && !visited[Rnr][Rnc])|| map[Rnr][Rnc] == 'O') {
					visited[Rnr][Rnc] = true;
					while(true) {
						if(map[Rnr][Rnc] == 'O') {
							Rtmp[2]++;
							Rcnt = Rtmp[2];
							return;
						}
						if(map[Rnr+dir[i][0]][Rnc+dir[i][1]] == '#' || map[Rnr+dir[i][0]][Rnc+dir[i][1]] == 'B') {
							int[] t = {Rnr,Rnc,Rtmp[2]+1};
							Rq.add(t);
							break;
						}
						Rnr += dir[i][0];
						Rnc += dir[i][1];
						visited[Rnr][Rnc] = true;
					}
				}
				if(map[Bnr][Bnc] == '.' || map[Bnr][Bnc] == 'O') {
					while(true) {
						if(map[Bnr][Bnc] == 'O') {
							Btmp[2]++;
							Bcnt = Btmp[2];
							return;
						}
						if(map[Bnr+dir[i][0]][Bnc+dir[i][1]] == '#' || map[Bnr+dir[i][0]][Bnc+dir[i][1]] == 'R') {
							int[] t = {Bnr,Bnc,Btmp[2]+1};
							Bq.add(t);
							break;
						}
						Bnr += dir[i][0];
						Bnc += dir[i][1];
					}
				}
			}
		}
	}
	
}
