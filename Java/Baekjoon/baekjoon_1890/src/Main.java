import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] board = new int[N][N];
		long [][] dp = new long[N][N];
		dp[0][0] = 1;
		
		for(int row = 0; row<N;++row) {
			for (int col = 0;col<N;++col)
				board[row][col] = sc.nextInt();
		}
		
		for(int row = 0; row<N;++row) {
			for (int col = 0;col<N;++col) {
				
				if( dp[row][col] == 0 || (row == N-1 && col == N-1))
					continue;
				
				int item = board[row][col];
				int next_r = row + item;
				int next_c = col + item;
				
				if(next_r < N) 
					dp[next_r][col] +=dp[row][col];
				if(next_c < N) 
					dp[row][next_c] +=dp[row][col];
				
			}
		}
		System.out.println(dp[N-1][N-1]);
	}

}
