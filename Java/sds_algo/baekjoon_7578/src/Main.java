import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int[] A, B, tree;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new int[500050];
        B = new int[1000010];
        tree= new int[500050];

        N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N;++i) A[i] = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N;++i) B[stoi(st.nextToken())] = i;

        long res = 0;

        for(int i = 1; i<=N;++i){
            res+= getSum(N) - getSum(B[A[i]]);
            update(B[A[i]]);
        }

        System.out.println(res);
    }

    private static int getSum(int i){
        int ret = 0;
        while (i > 0) {
            ret += tree[i];
            i -= (i&(-i));
        }
        return ret;
    }

    private static void update(int i){
        while(i<=N){
            tree[i] += 1;
            i += (i&(-i));
        }
    }
}
