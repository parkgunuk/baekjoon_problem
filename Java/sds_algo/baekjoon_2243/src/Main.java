import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}

    static long[] tree;
    static long ans;
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = stoi(br.readLine());

        int treeHeight = (int)Math.ceil(Math.log(MAX)/Math.log(2));
        tree = new long[1<<(treeHeight+1)];
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            if(stoi(st.nextToken()) == 1){
                int val = stoi(st.nextToken());
                long idx = query(1,0,MAX-1,val);
                ans = 0;
                update(1,0,MAX-1,(int)idx, -1);
            } else {
                int idx = stoi(st.nextToken());
                int diff = stoi(st.nextToken());
               update(1,0, MAX-1, idx, diff);
            }
        }
    }
    private static void update(int node, int s, int e, int idx, int diff){
        if(idx < s || idx > e) return;
        tree[node] += diff;

        if(s!=e){
            int mid = (s+e)>>1;
            update(node*2, s, mid, idx, diff);
            update(node*2+1, mid+1, e, idx, diff);
        }
    }

    private static long query(int node, int s, int e, int val){
        if(s == e && ans == 0) {
            System.out.println(s);
            return s;
        }

        // 자기 왼쪽 자식이 val개 이상 일때, 왼쪽 탐색
        if(ans == 0 && node*2 < tree.length && tree[node*2] >= val){
            return ans = query(node*2, s, (s+e)>>1, val);
        }

        val -= tree[node*2];

        //나머지는 모두 오른쪽 탐색
        if (ans == 0 && node*2+1<tree.length && tree[node*2+1] >= val){
            return ans = query(node*2+1,((s+e)>>1)+1,e,val);
        }

        return ans;
    }

}
