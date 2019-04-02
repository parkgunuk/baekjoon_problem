import java.util.*;
public class Main {
	static int N;
	static int[][] schdule;
	static int[] dp;
	static int max =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		schdule = new int[2][N+10];
		dp = new int[N+10];
		for(int i = 1;i<=N;++i) {
			schdule[0][i] = sc.nextInt();
			schdule[1][i] = sc.nextInt();
		}
		for(int i = 1;i<=N+1;++i) {
			
			dp[i] = Math.max(dp[i], max);
			dp[schdule[0][i]+i] = Math.max(dp[schdule[0][i]+i],schdule[1][i]+dp[i]);
			
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
	
}
