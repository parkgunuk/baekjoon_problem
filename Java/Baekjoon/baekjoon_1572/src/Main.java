import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static final int MAX = 65535;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        tree = new int[(MAX+1)*2];
        arr = new int[N];

        for (int i = 0; i < K; i++) {
            arr[i] = stoi(br.readLine());
            update(arr[i],1);
        }

        long sum = query(1,0,MAX, (K+1)>>1);
        for (int i = K; i < N; i++) {
            arr[i] = stoi(br.readLine());
            update(arr[i - K], -1);
            update(arr[i], 1);
            sum += query(1,0, MAX, (K+1)>>1);
        }

        System.out.println(sum);

    }

    private static void update(int node, int val){
        node += MAX + 1;
        tree[node] += val;

        while (node > 0) {
            node = node >> 1;
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    private static long query(int node, int s, int e, int k){
        if(s==e) return s;

        int mid = (s+e)>>1;
        if(tree[node*2] >= k) return query(node*2, s, mid, k);
        else return query(node*2+1, mid+1, e, k-tree[node*2]);

    }
}
