import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int H = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new long[1<<H+1];

        while (M-->0){
            st = new StringTokenizer(br.readLine());

            int cmd = stoi(st.nextToken());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            if( cmd == 0) {
                if(a>b){
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                System.out.println(query(1,0,N-1, a-1, b-1));
            } else {
                update(1,0,N-1,a-1, b);
            }
        }

    }
    private static void update(int n, int s, int e, int idx, int val){
        if(s<=idx && idx<=e){
            if(s==e) tree[n] = val;
            else{
                int mid = (s+e)>>1;
                update(n*2,s,mid,idx,val);
                update(n*2+1,mid+1,e,idx,val);

                tree[n] = (tree[n*2] + tree[n*2+1]);
            }
        }
    }

    private static long query(int node, int s, int e, int i, int j){
        if(j < s || e < i) return -1;
        if(i <= s && e <= j) return tree[node];

        int mid = (s+e) >> 1;

        long q1 = query(node*2, s, mid, i, j);
        long q2 = query(node*2+1, mid+1, e, i, j);

        if(q1 == -1) return q2;
        else if(q2 == -1) return q1;
        else return q1+q2;
    }
}