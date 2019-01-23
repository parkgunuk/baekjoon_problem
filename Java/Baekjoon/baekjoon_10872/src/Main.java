import java.io.*;

public class Main {
	static int[] dp = new int[13];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		dp[0] =1;
		dp[1] =1;
		
		for(int i = 2; i<13;++i)
			dp[i] = i * dp[i-1];
		
		System.out.println(dp[N]);
	}

}
