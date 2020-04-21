import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N, M, Q;
    private static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        Q = stoi(st.nextToken());

        root = new int[N+1];
        Arrays.fill(root, -1);

        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {0,0});
        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine());
            list.add(new int[] {stoi(st.nextToken()), stoi(st.nextToken())});
        }

        boolean[] visited = new boolean[M+1];

        Stack<Integer> reverseQuery = new Stack<>();

        for(int i = 0 ; i < Q ; ++i){
            int query = stoi(br.readLine());
            reverseQuery.add(query);
            visited[query] = true;
        }

        for(int i = 1 ; i <= M ; ++i){
            if(!visited[i]) {
                int[] tmp = list.get(i);
                union(tmp[0], tmp[1]);
            }
        }

        long ans = 0;

        for(int i = 0 ; i < Q ; ++i){
            int query = reverseQuery.pop();
            int[] input = list.get(query);

            int a = find(input[0]);
            int b = find(input[1]);

            if(a!=b) ans += root[a] * root[b];

            union(a,b);

        }

        System.out.println(ans);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return;

        root[a] += root[b];
        root[b] = a;
    }

    private static int find(int a){
        if(root[a] < 0) return a;
        return root[a] = find(root[a]);
    }
}
