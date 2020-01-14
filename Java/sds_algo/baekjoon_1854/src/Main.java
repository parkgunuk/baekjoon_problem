import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

// 플로이드 와샬로 해결할 경우 -> 메모리에서 초과
// 시작점이 1번 도시이고,
// 가중치가 양수 이기 때문에 다익스트라로 풀어야 한다.

public class Main {
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final int MAX = Integer.MAX_VALUE;
    static int n, m, k, a, b, c;
    static PriorityQueue<Integer>[] distQueue;
    static int[][] map;

    static class Node implements Comparable<Node>{
        int now;
        int cost;
        Node(int now, int cost){
            this.now = now;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken());

        distQueue = new PriorityQueue[n + 1];
        Comparator<Integer> compare = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 오름차순
                return o2-o1;
            }
        };

        for(int i = 0 ; i <n+1;++i) distQueue[i] = new PriorityQueue<>(k,compare);
        distQueue[1].add(0);
        map = new int[n+1][n+1];

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            a = stoi(st.nextToken());
            b = stoi(st.nextToken());
            c = stoi(st.nextToken());
            map[a][b] = c;
        }

        dijkstra();
        for (int i = 1; i <= n; i++) {
            if (distQueue[i].size() == k) System.out.println(distQueue[i].peek());
            else System.out.println(-1);
        }
    }
    private static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));

        while(!pq.isEmpty()){
            Node tmp = pq.poll();

            for(int i = 1; i<=n;++i){
                if(map[tmp.now][i] != 0){
                    // 저장된 경로가 K개가 안될 경우 그냥 추가한다.
                    if (distQueue[i].size() < k) {
                        distQueue[i].add(tmp.cost + map[tmp.now][i]);
                        pq.add(new Node(i, tmp.cost + map[tmp.now][i]));
                    }
                    // 저장된 경로가 K개이고, 현재 가장 큰 값보다 작다면
                    else if (distQueue[i].peek() > tmp.cost + map[tmp.now][i]) {
                        distQueue[i].poll();
                        distQueue[i].add(tmp.cost + map[tmp.now][i]);
                        pq.add(new Node(i, tmp.cost + map[tmp.now][i]));
                    }
                }
            }

        }
    }
}
