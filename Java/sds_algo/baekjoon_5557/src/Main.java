import java.util.*;
// https://6a68.tistory.com/15 공부 해야

/*
 3. 2차원배열 dp[N+1][21]를 생성한다.
         어떻게 풀어나갈 생각이냐면....
         dp[i][j]를 'i번째 수 까지 계산을 했을 때 j를 만들 수 있는 경우의 수'로 생각한다.
         예를들어,
                  dp[1][8] = 1    (8 = 8)
                  dp[2][5] = 1    (8 - 3 = 5)
                  dp[2][11] = 1  (8 + 3 = 11)
          이다.

    4. dp[i-1][]와 dp[i][]와의 관계를 설정한다.
          dp[i-1][j] != 0일때
          dp[i][j+ar[i]] += dp[i-1][j],
          dp[i][j-ar[i]] += dp[i-1][j]  이다!, 단 여기서 j-ar[i] > 20 이거나 j < 0 인 경우는 제외한다.

    5. 모든 연산을 마치고 dp[N-1][ar[N-1]]을 출력한다.(코드에서는 dp[N][21] 배열을 생성해서 dp[N-2][ar[N-1]]을 출력했다..)

 */
public class Main {
    static int N;
    static int arr[];
    static long dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        arr = new int[N];
        dp = new long[N][21];

        String[] tmp = sc.nextLine().split(" ");
        for(int i = 0; i < tmp.length; i++) arr[i] = Integer.parseInt(tmp[i]);

        dp[0][arr[0]] = 1;

        for(int i = 1; i < N-1; i++){
            for(int j = 0; j <= 20; j++){
                if(dp[i-1][j] != 0){
                    if(j-arr[i] >= 0){
                        dp[i][j-arr[i]] += dp[i-1][j];
                    }
                    if(j+arr[i] <= 20){
                        dp[i][j+arr[i]] += dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[N-2][arr[N-1]]);
    }
}
