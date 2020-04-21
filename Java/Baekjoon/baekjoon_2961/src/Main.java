import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N;
    static long ans;
    static long[] sour, bitter;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());

        ans = Long.MAX_VALUE;
        sour = new long[N+1];
        bitter = new long[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i<N;++i){
            st = new StringTokenizer(br.readLine());
            sour[i] = stoi(st.nextToken());
            bitter[i] = stoi(st.nextToken());
        }

        for(int i = 0; i<N;++i){
            visited[i] = true;
            rec(sour[i], bitter[i]);
            visited[i] = false;
        }

        System.out.println(ans);
    }
    private static void rec(long s, long b){
        ans = Math.min(ans, Math.abs(s-b));
        for(int i = 0; i<N;++i){
            if(visited[i])continue;
            visited[i] = true;
            rec(s*sour[i], b+bitter[i] );
            visited[i] = false;
        }
    }
}
