import java.util.*;
import java.io.*;
//벨만포드 알고리즘
public class Main {
    static final int MAX = Integer.MAX_VALUE;
    private static int stoi(String input) {return Integer.parseInt(input);}
    static int N,M,A,B,C;
    static int[] distance;
    static boolean flag;
    static class Node implements Comparable<Node>{
        int u,v,w;
        Node(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static Node[] nodes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        distance = new int[N+1];
        nodes = new Node[M+1];
        Arrays.fill(distance, MAX);
        distance[1] = 0;

        for(int i = 1 ; i<=M;++i){
            st = new StringTokenizer(br.readLine());
            A = stoi(st.nextToken());
            B = stoi(st.nextToken());
            C = stoi(st.nextToken());

            nodes[i] = new Node(A,B,C);
        }

        if (bellman_ford()) {
            for (int i = 2; i < N + 1; ++i) {
                System.out.println(distance[i] == MAX ? -1 : distance[i]);
            }
        } else System.out.println(-1);

    }

    private static boolean bellman_ford(){
        for(int i = 1; i <= N; i++) {
            flag = true;
            for(int j = 1; j <= M; j++) {
                if(distance[nodes[j].u] == Integer.MAX_VALUE) {
                    continue;
                }
                if(distance[nodes[j].u] + nodes[j].w < distance[nodes[j].v] ) {
                    distance[nodes[j].v] = distance[nodes[j].u] + nodes[j].w;
                    flag = false;
                }
            }
            if(flag == true) {
                return true;
            }
        }

        return false;
    }
}
