import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N, K, M;
    private static ArrayList<Integer>[] tree;

    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        M = stoi(st.nextToken());

        tree = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; ++i) tree[i] = new ArrayList<>();

        for(int i = 0 ; i < M ; ++i){
            st = new StringTokenizer(br.readLine());

            for(int j = 0 ; j < K ; ++j){
                int n = stoi(st.nextToken());
                tree[i].add(n);
                tree[n].add(i);
            }
        }

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = dist[1] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()){
            int val = q.poll();
            for(int i : tree[val]){
                if(dist[i] > dist[val]+1){
                    dist[i] = dist[val]+1;
                    q.add(i);
                }
            }
        }

        System.out.println(dist[N] == Integer.MAX_VALUE ? -1 : dist[N]);
    }
}