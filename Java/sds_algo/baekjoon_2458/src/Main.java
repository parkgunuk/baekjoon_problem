import java.util.*;
import java.io.*;
public class Main {

    static boolean[][] map;
    static int N, M;
    static int cnt, ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map= new boolean[N+1][N+1];
        ans = 0;
        for(int i= 0;i<M;++i) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = true;

        }
        for(int k = 1;k<=N;++k) {
            for(int i =1; i<=N;++i) {
                for(int j =1; j<=N;++j) {
                    if(map[i][k] && map [k][j]) map[i][j] =true;
                }
            }
        }

        for(int i = 1; i<=N;++i) {
            cnt = 0;
            for(int j =1; j<=N;++j) {
                if(i==j) continue;
                if(map[i][j] || map[j][i]) cnt++;
            }
            if(cnt == N-1) ans++;
        }

        System.out.println(ans);
    }


}
