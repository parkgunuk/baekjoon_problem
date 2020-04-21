import java.util.*;
import java.io.*;
public class Main {
    private static long stol(String s){return Long.parseLong(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] dist = new long[N-1];

        long pre = Long.MAX_VALUE;
        long ans = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N-1;++i) dist[i] = stol(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            long val = stol(st.nextToken());
            pre = Math.min(pre, val);
            ans += pre * dist[i];
        }

        System.out.println(ans);
    }
}
