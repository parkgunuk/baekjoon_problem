import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static final int INF = 987654321;
    private static int N, M ,T, D;
    private static final int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static int[][] map, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        T = stoi(st.nextToken());
        D = stoi(st.nextToken());

        map = new int[N+1][M+1];
        time = new int[N*M+1][N*M+1];

        for(int i = 0 ; i <= N*M ; ++i) {
            Arrays.fill(time[i], INF);
            time[i][i] = 0;
        }

        for(int i = 0 ; i < N ; ++i){
            char[] input = br.readLine().toCharArray();
            for(int j = 0 ; j < M ; ++j){
                if(input[j] >= 'A' && input[j] <= 'Z') map[i][j] = input[j] - 'A';
                if(input[j] >= 'a' && input[j] <= 'z') map[i][j] = input[j] - 'a' + 26;
            }
        }

        for (int r = 0 ; r < N ; ++r) {
            for(int c = 0 ; c < M ; ++c){
                int here = r*M + c;

                for (int i = 0;i < 4;i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                    int next = nr*M + nc;
                    int diff = map[r][c] - map[nr][nc];

                    if (Math.abs(diff) > T) continue;

                    if (diff > 0) time[here][next] = 1; // 내리막길
                    else if (diff < 0) time[here][next] = diff*diff; // 오르막길
                    else time[here][next] = 1;
                }
            }
        }

        int MAX = N*M;
        for (int k = 0;k < MAX;k++) {
            for (int n = 0;n < MAX;n++) {
                for (int m = 0;m < MAX;m++) {
                    if (time[n][m] > time[n][k] + time[k][m])
                        time[n][m] = time[n][k] + time[k][m];
                }
            }
        }

        System.out.println(findValue());
//        print();
    }

    private static int findValue(){
        int ans = 0;
        for (int r = 0 ; r < N*M ; ++r) {
            if (time[0][r] + time[r][0] <= D) {
                ans = Math.max(ans, map[r / M][r % M]);
//                System.out.println(ans + "///" + r/M + " " + r%M);

            }
        }
        return ans;
    }

    private static void print(){
        for(int i = 1 ; i <= N ; ++i){
            for(int j = 1 ; j <= M ; ++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}