import java.util.*;
import java.io.*;


/*
    * 전체 백트래킹하면 시간초과
    * 그렇기에 전체가 아닌 흑과 백으로 나누어 백트래킹
 */
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N;
    private static int[] res;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        res = new int[2];
        map = new int[N+1][N+1];
        visited = new boolean[2][2*N+1];

        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; ++j){
                map[i][j] = stoi(st.nextToken());
            }
        }
        rec(0, 0, 0, 0);
        rec(0 ,1, 0, 1);

        System.out.println(res[0]+res[1]);

    }

    private static void rec(int r, int c, int cnt, int color){
        res[color] = Math.max(res[color],cnt);
        if(r>=N)    return;
        if(c>=N) {
            r++;
            c = color^(r%2);
        }
        if(map[r][c] == 1 && !visited[0][r+c] && !visited[1][N-(r-c)]) {
            visited[0][r+c] = true;
            visited[1][N-(r-c)] = true;
            rec(r,c+2,cnt+1,color);
            visited[0][r+c] = false;
            visited[1][N-(r-c)] = false;
        }
        rec(r, c+2, cnt, color);
    }
}