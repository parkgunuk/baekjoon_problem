import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}

    static int N, M, K;
    static long[] tree, lazy, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new long[1<<H+1];
        lazy = new long[1<<H+1];
        arr = new long[N];

        for(int i = 0; i<N;++i) arr[i] = stoi(br.readLine());
        init(1,0,N-1);

        for(int i = 0; i<M+K;++i){
            st = new StringTokenizer(br.readLine());
            int cmd = stoi(st.nextToken());
            if(cmd == 1){
                int s = stoi(st.nextToken());
                int e = stoi(st.nextToken());
                long v = stol(st.nextToken());

                update(1, 0, N-1, s-1, e-1, v);

            } else if(cmd == 2) {
                int s = stoi(st.nextToken());
                int e = stoi(st.nextToken());

                System.out.println(query(1,0,N-1,s-1,e-1));
            }
        }
    }

    private static long init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];

        int mid = (s + e)>>1;
        return tree[node] = init(node * 2, s, mid) + init(node * 2 + 1, mid + 1, e);
    }

    private static void update_lazy(int node, int s, int e){
        if (lazy[node] != 0) {
            tree[node] += (e-s+1)*lazy[node];
            // leaf가 아니면
            if (s != e) {
                lazy[node*2] += lazy[node];
                lazy[node*2+1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    private static void update(int node, int s, int e, int l, int r, long diff){
        update_lazy(node, s, e);
        if (l > e || r < s) return;
        if (l <= s && e <= r) {
            tree[node] += (e-s+1)*diff;
            if (s != e) {
                lazy[node*2] += diff;
                lazy[node*2+1] += diff;
            }
            return;
        }

        int mid = (s+e)>>1;
        update(node*2, s, mid, l, r, diff);
        update(node*2+1, mid+1, e, l, r, diff);
        tree[node] = tree[node*2] + tree[node*2+1];
    }

    private static long query(int node, int s, int e, int l, int r){
        update_lazy(node, s, e);

        if (l > e || r < s) return 0;
        if(l<=s && e<=r) return tree[node];

        int mid = (s+e)>>1;
        return query(node*2, s, mid, l, r) + query(node*2+1, mid+1, e, l, r);
    }
}
