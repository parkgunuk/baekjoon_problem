import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int N, M, a, b;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());

        st = new StringTokenizer(br.readLine());
        a = stoi(st.nextToken());
        b = stoi(st.nextToken());

        M = stoi(br.readLine());

        tree = new ArrayList[N+1];
        for(int i = 1 ; i<=N;++i) tree[i] = new ArrayList<>();

        for(int i = 0; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int c = stoi(st.nextToken());
            int d = stoi(st.nextToken());

            tree[c].add(d);
            tree[d].add(c);
        }

        visited = new boolean[N+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visited[a] = true;
        int ans = 0;
        boolean flag = false;
        while(true){
            int size = q.size();
            if(size == 0) {
                ans = -1;
                break;
            }
            while(size-->0){
                int cur = q.poll();
                for(int i : tree[cur]){
                    if(visited[i]) continue;
                    q.add(i);
                    visited[i] = true;
                    if(i == b) {
                        flag = true;
                        break;
                    }
                }
            }
            ans++;
            if(flag) break;
        }
        System.out.println(ans);
    }
}
