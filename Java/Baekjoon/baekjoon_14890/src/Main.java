import java.util.*;

public class Main {
	static int N, L, ans;
	static int[][] map1;
	static int[][] map2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		L = sc.nextInt();
		ans = 0;
		map1 = new int[N][N];
		map2 = new int[N][N];
		
		for(int r =0;r<N;++r) {
			for(int c = 0;c<N;++c) {
				map1[r][c] = map2[c][r] = sc.nextInt();
			}
		}
		for(int idx = 0; idx<N;++idx) {
			Check(idx,map1);
			Check(idx,map2);
		}
		System.out.println(ans);
	}
	static void Check(int idx, int[][] map) {
		int[] tmp = new int[N];
		
		for(int i = 0;i<N-1;++i) {
			if(map[idx][i] != map[idx][i+1]) {
				int height = map[idx][i]-map[idx][i+1];
				if(Math.abs(height) != 1) return;
				if(height == 1) {
					for(int j=1;j<=L;++j) {
						if(i+j>=N||tmp[i+j]==1)return;
						if(map[idx][i]-1 == map[idx][i+j]) tmp[i+j]=1;
						else return;
					}
				}
				else {
					for(int j=0;j<L;++j) {
						if(i-j<0 || tmp[i-j] == 1) return; 
						if(map[idx][i] == map[idx][i-j]) tmp[i-j] = 1;
						else return;
					}
				}
			}
			
		}
		ans++;
	}
}