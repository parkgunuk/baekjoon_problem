import java.util.*;
import java.io.*;
public class Main {
    static final int MAX = Integer.MAX_VALUE;
    private static int stoi(String s){return Integer.parseInt(s);}
//    static int[] ddr;
//    static int[][][] dp;
    static int[][] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        ddr = new int[100001];
//        dp = new int[5][5][100001]; // 왼발, 오른발, 현재 위치
        DP = new int[5][5]; // 왼발 오른발 위치..

        for(int i = 0 ; i<5;++i) Arrays.fill(DP[i], MAX);
        DP[0][0] = 0;

        int idx = 0;
        int ans = MAX;
//        while(st.hasMoreTokens()){
        while(true) {
//            ddr[idx++] = stoi(st.nextToken());
            int input = stoi(st.nextToken());
            if(input == 0 ) break;
            int[][] tmp = new int[5][5];
            for(int i = 0 ; i<5; ++i) Arrays.fill(tmp[i], MAX);

            for(int l = 0 ; l<5;++l){
                for(int r = 0;r<5;++r){
                    if(DP[l][r] == MAX) continue;
                    // 왼발을 옮겼을 때,
                    if (input != r){
                        if (tmp[input][r] > DP[l][r] + from2step(l, input))
                            tmp[input][r] = DP[l][r] + from2step(l, input);
                    }
                    // 오른발을 옮겼을 떄,
                    if (input != l) {
                        if (tmp[l][input] > DP[l][r] + from2step(r, input))
                            tmp[l][input] = DP[l][r] + from2step(r, input);
                    }

                }
            }
            for(int i = 0 ; i<5;++i){
                for(int j = 0 ; j<5;++j){
                    DP[i][j] = tmp[i][j];
                }
            }
        }

        for(int i = 0 ; i<5;++i){
            for(int j = 0 ; j <5;++j)
                ans = ans>DP[i][j]?DP[i][j]:ans;
        }

        System.out.println(ans);

//        System.out.println(move(0,0,0));

    }

    private static int from2step(int from, int to){
        if(from == to) return 1;
        if(from == 0) return 2;
        else if(Math.abs(from-to) == 2) return 4;
        else return 3;

    }

    // 재귀로 풀 경우 시간초과
//    private static int move(int prev, int next, int step){
//        if(ddr[step] == 0) return 0;
//        int res = dp[prev][next][step];
//        if(res>0) return res;
//        if(next == ddr[step] || prev == ddr[step]) res = move(prev, next, step + 1) + 1; // 같은 지점을 밟았기에 +1
//        else res = Math.min(from2step(prev, ddr[step]) + move(ddr[step], next, step + 1),
//                from2step(next, ddr[step]) + move(prev, ddr[step], step + 1));
//                // 직전의 결과에서, prev의 위치와 next위치를 둘다 옮겨서 결과를 확인 했을 때, 더 작은 값이 res 된다.
//
//        return res;
//    }
}
