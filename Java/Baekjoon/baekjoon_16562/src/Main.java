import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N, M, K;
    static int[] root, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        root = new int[N+1];
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N;++i) root[i] = i;

        for(int i = 1 ; i<=N;++i) arr[i] = stoi(st.nextToken());
        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            union(stoi(st.nextToken()), stoi(st.nextToken()));
        }
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (find(0) != find(i)) {
                ans += arr[find(i)];
                union(0, i);
            }
        }
        if (ans <= K) System.out.println(ans);
        else System.out.println("Oh no");
    }

    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return false;

        if (arr[a] < arr[b]) root[b] = a;
        else root[a] = b;

        return true;
    }

    private static int find(int a){
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
