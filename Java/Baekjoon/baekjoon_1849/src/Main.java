import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int N, H;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = stoi(br.readLine());

        H = (int)Math.ceil(Math.log(N)/Math.log(2));
        tree = new int[1<<H+1];
        arr = new int[N+1];

        for(int i = 1 ; i <= N ; ++i) update(1, 1, N, i, 1);
        for(int i = 1 ; i <= N ; ++i){
            int val = stoi(br.readLine());
            int q = query(1, 1, N, val+1);
            arr[q] = i;
            update(1, 1, N, q,0);
        }
        for(int i = 1; i<=N;++i) bw.write(arr[i]+"\n");
        bw.close();
    }

    private static void update(int node, int s, int e, int idx, int val){
        if(e < idx || idx < s) return;
        if(s==e){
            tree[node] = val;
            return;
        }
        int mid = (s+e)>>1;
        update(node*2,s,mid,idx,val);
        update(node*2+1,mid+1,e,idx,val);
        tree[node] = tree[node*2]+tree[node*2+1];
    }

    private static int query(int node, int s, int e, int val){
        if(s==e) return s;
        int mid = (s+e) >> 1;
        if(tree[node*2] >= val) return query(node*2, s, mid, val);
        else return query(node*2+1, mid+1, e, val-tree[node*2]);
    }
}