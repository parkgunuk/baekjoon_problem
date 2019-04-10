import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	static int[] teamA , teamB;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int r=0;r<N;++r) {
			for(int c=0;c<N;++c) {
				map[r][c] = sc.nextInt();
			}
		}
		teamA = new int[N/2];
		teamB = new int[N/2];
		go(0,-1);
		
		System.out.println(ans);
	}
	static void go(int lev, int b) {
		if(lev == N/2) {
			int idx = 0;
			for(int i = 1; i<=N; ++i) {
				boolean flag = false;
				for(int j = 0; j<N/2;++j) {
					if(teamA[j] == i) {
						flag = true;
						break;
					}
				}
				if(!flag) teamB[idx++] = i;
			}
			int a = Math.abs(cal(teamA) - cal(teamB));
			ans = Math.min(ans, a);
			return;
		}
		for(int i = 1;i<=N;++i) {
			if(b >= i) continue;
			teamA[lev] = i;
			go(lev+1,i);
		}
	}
	static int cal(int[] team) {
		int res = 0;
		for(int i = 0;i<N/2;++i) {
			for(int j = 0; j<N/2;++j) {
				if(i==j) continue;
				res += map[team[i]-1][team[j]-1];
			}
		}
		return res;
	}
}
