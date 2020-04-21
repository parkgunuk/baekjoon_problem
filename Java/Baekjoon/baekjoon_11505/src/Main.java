import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static final int mod = 1000000007;

    static int N,M,K;
    static int[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        arr = new int[N];
        for(int i = 0 ; i<N;++i) arr[i] = stoi(br.readLine());

        int treeHeight = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];

        init(1, 0, N - 1);

        int T = M+K;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            if(a==1){
                update(1,0,N-1,b-1,c);
                arr[b-1] = c;
            } else if(a==2){
                System.out.println(getMul(1,0,N-1,b-1,c-1));
            }
        }

    }
    private static void init(int n, int s, int e) {
        if(s==e) tree[n] = arr[s]%mod;
        else{
            int mid = (s+e)>>1;
            init(n*2,s,mid);
            init(n*2+1,mid+1,e);

            tree[n] = (tree[n*2] * tree[n*2+1])%mod;
        }
    }

    private static void update(int n, int s, int e, int idx, int val){
        if(s<=idx && idx<=e){
            if(s==e) tree[n] = val%mod;
            else{
                int mid = (s+e)>>1;
                update(n*2,s,mid,idx,val);
                update(n*2+1,mid+1,e,idx,val);

                tree[n] = (tree[n*2] * tree[n*2+1])%mod;
            }
        }
    }

    private static long getMul(int n, int s, int e, int i, int j){
        if(j < s || i > e) return -1;

        if (i <= s && e <= j) return tree[n];
        int half = (s + e)>>1;

        long m1 = getMul(n * 2, s, half, i, j);
        long m2 = getMul(n * 2 + 1, half + 1, e, i, j);

        if (m1 == -1) return m2;
        else if (m2 == -1) return m1;
        else return (m1 * m2) % 1000000007;

    }
}
