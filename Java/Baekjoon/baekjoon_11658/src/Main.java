import java.io.*;
import java.util.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    static int N, M;
    static long[][] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new long[N][1<<H+1];
        arr = new long[N][N];

        for(int i = 0 ; i<N;++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j)
                arr[i][j] = stoi(st.nextToken());
        }
        for(int i = 0 ; i<N;++i) init(1,0,N-1, i);

        for(int i = 0; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int cmd = stoi(st.nextToken());

            if(cmd == 0) {
                int x = stoi(st.nextToken());
                int y = stoi(st.nextToken());
                int val = stoi(st.nextToken());

                update(1,0,N-1, x-1, y-1, val);
            } else if(cmd == 1) {
                int x1 = stoi(st.nextToken());
                int y1 = stoi(st.nextToken());
                int x2 = stoi(st.nextToken());
                int y2 = stoi(st.nextToken());
                long ans = 0;

                for(int j = x1 ; j<=x2;++j){
                    ans += query(1, 0, N-1, j-1, y1-1, y2-1);
                }
                System.out.println(ans);
            }
        }
    }

    private static long init(int node, int s, int e, int x) {
        if (s == e) return tree[x][node] = arr[x][s];

        int mid = (s + e)>>1;
        return tree[x][node] = init(node * 2, s, mid, x) + init(node * 2 + 1, mid + 1, e, x);
    }

    private static void update(int node, int s, int e, int x1, int y1, int val){
        if(s<=y1 && y1<=e){
            if(s==e) tree[x1][node] = val;
            else{
                int mid = (s+e)>>1;
                update(node*2, s, mid, x1, y1, val);
                update(node*2+1, mid+1, e, x1, y1, val);

                tree[x1][node] = tree[x1][node*2] + tree[x1][node*2+1];
            }
        }
    }

    private static long query(int node, int s, int e, int x, int l, int r) {
        if (l > e || r < s) return 0;
        if (l <= s && e <= r) return tree[x][node];

        int mid = (s + e) >> 1;
        return query(node * 2, s, mid, x, l, r) + query(node * 2 + 1, mid + 1, e, x, l, r);
    }
}
