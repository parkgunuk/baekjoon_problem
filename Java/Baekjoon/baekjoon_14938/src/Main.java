import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int n,m,r;
    static int[] item;
    static int[][] w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        r = stoi(st.nextToken());

        item = new int[n+1];
        w = new int[n+1][n+1];

        for(int i = 1 ; i <= n; ++i) Arrays.fill(w[i], 16);

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; ++i) item[i] = stoi(st.nextToken());

        for(int i = 0 ; i < r ; ++i){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            w[a][b] = Math.min(w[a][b], c);
            w[b][a] = Math.min(w[a][b], c);
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                for (int k = 1; k <= n; ++k) {
                    if (j == k) w[j][k] = 0;
                    w[j][k] = Math.min(w[j][k], w[j][i] + w[i][k]);
                }
            }
        }
//        for(int i = 1 ; i <= n ; ++i){
//            for(int j = 1; j <= n ; ++j){
//                System.out.print(w[i][j] + " " );
//            }
//            System.out.println();
//        }

        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            int curr = 0;
            for (int j = 1; j <= n; ++j) {
                if (w[i][j] <= m) curr += item[j];
            }
            ans = Math.max(ans, curr);
        }

        System.out.println(ans);
    }
}
