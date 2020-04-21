import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static StringBuilder sb;
    private static int B, P, Q;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = stoi(br.readLine());
        while(T-->0){
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            B = stoi(st.nextToken());
            P = stoi(st.nextToken());
            Q = stoi(st.nextToken());

            int len = (int) Math.ceil(Math.log(B) / Math.log(2));
            tree = new long[1<<len+1];

            for(int i = 0 ; i < P+Q ; ++i){
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());

                if(cmd.equals("P")){
                    update(1, B, 1, a, b);
                } else {
                    sb.append(query(1, B, 1, a, b)+"\n");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static long update(int s, int e, int n, int i, int d) {
        if (i > e || i < s) return tree[n];
        if (s == e) return tree[n] += d;

        int m = s + e >> 1;
        return tree[n] = update(s, m, 2 * n, i, d) + update(m + 1, e, 2 * n + 1, i, d);
    }

    private static long query(int s, int e, int n, int l, int r) {
        if (l > e || r < s) return 0;
        if (l <= s && e <= r) return tree[n];

        int m = s + e >> 1;
        return query(s, m, 2 * n, l, r) + query(m+1, e, 2 * n +1, l, r);
    }
}