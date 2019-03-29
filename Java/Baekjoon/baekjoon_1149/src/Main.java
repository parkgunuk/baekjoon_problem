import java.util.*;

public class Main {
	
	static int[][] RGB;
	static int N, ans;
	static int[] cache;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		RGB = new int[N][3];
		cache = new int[3];
		ans = Integer.MAX_VALUE;
		
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<3;++c) {
				RGB[r][c] = sc.nextInt();
			}
		}
		int[] tmp = go(N-1);
		for(int i = 0; i<tmp.length; ++i) {
			ans = ans<tmp[i]?ans:tmp[i];
		}
		System.out.println(ans);
	}
	static int[] go(int lev) {
		if(lev == -1) {
			int[] tmp = {0,0,0};
			return tmp;
		}
		cache = go(lev-1);
		
		RGB[lev][0] += myMin(cache[1],cache[2]);
		RGB[lev][1] += myMin(cache[0],cache[2]);
		RGB[lev][2] += myMin(cache[1],cache[0]);
		
		return RGB[lev];
	}
	static int myMin(int a, int b) {
		return a>b?b:a;
	}
}
