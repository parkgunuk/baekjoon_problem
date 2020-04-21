import java.util.*;
import java.io.*;

public class Main {
	private static int stoi(String s){return Integer.parseInt(s);}

	private static class node{
		int r, c, dust;

		private node(int r, int c, int dust){
			this.r = r;
			this.c = c;
			this.dust = dust;
		}

	}

	static int R,C,T, ar1, ac1, ar2, ac2;
	static int[][] map, dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static Queue<node> dustList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = stoi(st.nextToken());
		C = stoi(st.nextToken());
		T = stoi(st.nextToken());
		map = new int[R][C];
		dustList = new LinkedList<>();

		boolean flag = false;

		for(int r = 0 ; r<R;++r){
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ;c<C;++c){
				map[r][c] = stoi(st.nextToken());
//				if(map[r][c] > 0) dustList.add(new node(r,c,map[r][c]));
				if(map[r][c] == -1) ar2 = r;
			}
		}
		ar1 = ar2-1;

		while(T-->0){
			findDust();
			spread();
			cleaner();
		}
		findDust();
		int sum = 0;
		for(node n : dustList) sum+=n.dust;

		System.out.println(sum);
	}

	private static void cleaner() {
		for (int i = ar1 ; i >0 ; i--) {
			map[i][0] = map[i-1][0];
		}
		map[ar1][0] = 0;
		for (int i = 0; i < C - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < ar1; i++) {
			map[i][C-1] = map[i + 1][C-1];
		}
		for (int i = C - 1; i >= 1; i--) {
			map[ar1][i] = map[ar1][i - 1];
		}
		map[ar1][0] = -1;
		//아래 시계방향
		for (int i = ar2; i < R-1 ; i++) {
			map[i][0] = map[i+1][0];
		}
		map[ar2][0] =0;
		for (int i = 0; i < C - 1; i++) {
			map[R-1][i] = map[R-1][i + 1];
		}
		for (int i = R-1; i > ar2; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for (int i = C - 1; i >= 1; i--) {
			map[ar2][i] = map[ar2][i - 1];
		}
		map[ar2][0] = -1;
	}

	private static void spread(){
		while(!dustList.isEmpty()){
			node n = dustList.poll();
			int cnt = 0;
			for(int i = 0 ; i<4;++i){
				int nr = n.r + dir[i][0];
				int nc = n.c + dir[i][1];

				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(map[nr][nc] < 0) continue;
				cnt++;
				map[nr][nc] += n.dust/5;
			}
			map[n.r][n.c] -= (n.dust/5)*cnt;
		}
	}

	private static void findDust(){
		for(int r = 0 ; r<R ; ++r){
			for(int c = 0 ; c<C ; ++c){
				if(map[r][c] > 0) dustList.add(new node(r, c, map[r][c]));
			}
		}
	}
}
