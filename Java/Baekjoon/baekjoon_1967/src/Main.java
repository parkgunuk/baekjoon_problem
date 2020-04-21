import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int v, cost;
        private Node(int v, int cost){
            this.v  = v;
            this.cost = cost;
        }

    }

    private static ArrayList<Node>[] tree;
    private static boolean visited[];
    private static int N, d = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());

        visited = new boolean[N+1];
        tree = new ArrayList[N+1];
        for(int i = 0 ; i <= N ; ++i) tree[i] = new ArrayList<>();

        for(int i = 0 ; i < N-1 ; ++i){
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            int cost = stoi(st.nextToken());

            tree[u].add(new Node(v,cost));
        }
        visited[1] = true;
        rec(1);
        System.out.println(d);
    }

    private static int rec(int u){
        int max1 = 0;
        int max2 = 0;

        for(Node n : tree[u]){
            if(visited[n.v]) continue;
            visited[n.v] = true;
            int dist = rec(n.v) + n.cost;

            if(dist > max1){
                max2 = max1;
                max1 = dist;
            }
            // dist 가 두번째로 크면
            else if(dist > max2) max2 = dist;
        }
        d = Math.max(d,  max1+max2);
        return max1;
    }
}
