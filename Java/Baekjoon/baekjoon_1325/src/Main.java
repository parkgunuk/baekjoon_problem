import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N,M;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] ans = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        tree = new ArrayList[N+1];
        for(int i = 1; i<=N;++i) tree[i] = new ArrayList<>();
        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            tree[A].add(B);
        }

        for(int i =1; i<= N ;i++){
            visited = new boolean[N+1];
            DFS(i);
        }

        int max = Integer.MIN_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i<=N;++i) max = Math.max(max, ans[i]);
        for(int i = 1;i<=N;++i){
            if(ans[i] == max) sb.append(i+" ");
        }

        System.out.println(sb.toString());

    }

    private static void DFS(int n){
        visited[n] = true;
        for(int i : tree[n]){
            if(visited[i]) continue;
            DFS(i);
            ans[i]++;
        }

    }
}
