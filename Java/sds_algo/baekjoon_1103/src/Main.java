import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int[][] dp;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int ans;
    static int R, C;
    static boolean[][] visited;
    static boolean isCycle;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        dp = new int[R][C];
        visited = new boolean[R][C];
        ans = 0;
        isCycle = false;

        for (int r = 0; r < R; ++r) {
            char[] tmp = br.readLine().toCharArray();
            for(int c = 0 ; c<C;++c){
                map[r][c] = tmp[c];
                if(tmp[c] == 'H'){
                    dp[r][c] = -1;
                    visited[r][c] = true;
                }
            }
        }
        ans = dfs(0,0);
        if(isCycle) System.out.println(-1);
        else System.out.println(dfs(0, 0));
    }

    private static int dfs(int r, int c) {
        if (isCycle) return 0;
        if (r < 0 || r >= R || c < 0 || c >= C || map[r][c] == 'H') return 0;
        if (visited[r][c]) {
            isCycle = true;
            return 0;
        }
        if (dp[r][c] != 0) return dp[r][c];

        visited[r][c] = true;
        int move = map[r][c] - '0';
        int temp = 0;

        temp = Math.max(temp, dfs(r - move, c) + 1);
        temp = Math.max(temp, dfs(r + move, c) + 1);
        temp = Math.max(temp, dfs(r, c - move) + 1);
        temp = Math.max(temp, dfs(r, c + move) + 1);

        dp[r][c] = temp;
        
        visited[r][c] = false;

        return dp[r][c];
    }
}

