import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int[] tree, arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        while(true){
            sb = new StringBuilder();

            String s = br.readLine();
            if(s.equals("")) break;

            st = new StringTokenizer(s);
            int N = stoi(st.nextToken());
            int K = stoi(st.nextToken());

            int height = (int)Math.ceil(Math.log(N)/Math.log(2));

            tree = new int[1<<height+1];
            Arrays.fill(tree,1);

            arr = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i< N;++i) arr[i] = stoi(st.nextToken());
            init(1,0,N-1);
//            System.out.println(Arrays.toString(tree));

            while(K-->0){
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                ans = 1;
                if(cmd.equals("C")){
                    update(1,0,N-1,a-1,b);
//                    System.out.println(Arrays.toString(tree));
                    arr[a-1] = b;
                } else if (cmd.equals("P")){
                    query(1,0,N-1,a-1,b-1);
                    if(ans>0) sb.append("+");
                    else if(ans==0) sb.append("0");
                    else sb.append("-");
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static void init(int n, int s, int e) {

        if(s==e) {
            int a = arr[s];
            if(a>0) tree[n] = 1;
            else if (a==0) tree[n] = 0;
            else tree[n] = -1;
        }

        else{
            int mid = (s+e)>>1;
            init(n*2,s,mid);
            init(n*2+1,mid+1,e);

            tree[n] = tree[n*2] * tree[n*2+1];
        }
    }

    private static void update(int n, int s, int e, int idx, int val){
        if(s<=idx && idx<=e){
            if(s==e) {
                if(val>0) tree[n] = 1;
                else if (val==0) tree[n] = 0;
                else tree[n] = -1;
            }
            else{
                int mid = (s+e)>>1;
                update(n*2,s,mid,idx,val);
                update(n*2+1,mid+1,e,idx,val);

                tree[n] = tree[n*2] * tree[n*2+1] ;
            }
        }
    }


    private static void query(int n, int s, int e, int i, int j){
        if(j < s || i > e) return ;
        if (i <= s && e <= j) {
            ans *= tree[n];
            return;
        }

        int mid = (s+e) >> 1;
        query(n*2,s,mid,i,j);
        query(n*2+1,mid+1,e,i,j);

    }
}