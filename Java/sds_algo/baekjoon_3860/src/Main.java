import java.util.*;
import java.io.*;
// never 조건은 음의 루프이기 때문에, 벨만포드 알고리즘으로 풀어야합니다..
public class Main {
    private static int stoi(String input){return Integer.parseInt(input);}
    static int W,H,G,E,X1,Y1,X2,Y2,T,V,B;
    static final int MAX = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] distance;
    static ArrayList<Node> nodes;
    static ArrayList<Integer> holeList;

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

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            W = stoi(st.nextToken());
            H = stoi(st.nextToken());

            // 노드의 개수 : W*H - G
            // 간선의 개수 : bfs로 직접 돌자

            if(W==0 && H == 0) break;

            G = stoi(br.readLine());
            map = new int[H][W];
            visited = new boolean[H][W];

            for(int i = 0 ; i<G;++i){
                st = new StringTokenizer(br.readLine());
                int x = stoi(st.nextToken());
                int y = stoi(st.nextToken());

                map[y][x] = -1;
            }

            int number = 1;
            for(int r = 0;r<H;++r){
                for(int c = 0 ;c<W;++c){
                    if(map[r][c] == 0){
                        map[r][c] = number++;
                    }
                }
            }
            nodes = new ArrayList<>();
            // 노드 넘버링
            E = stoi(br.readLine());
            // 귀신구멍의 수는 여러개구나....
            holeList = new ArrayList<>();
            for(int i = 0 ;i<E;++i){
                st = new StringTokenizer(br.readLine());
                X1 = stoi(st.nextToken());
                Y1 = stoi(st.nextToken());
                X2 = stoi(st.nextToken());
                Y2 = stoi(st.nextToken());
                T = stoi(st.nextToken());

                nodes.add(new Node(map[Y1][X1], map[Y2][X2], T));
                holeList.add(map[Y1][X1]);
            }

            V = W*H-G;
            B = getEdge();  // 노드 추가작업

            distance = new int[V+1];
            Arrays.fill(distance, MAX);
            distance[1] = 0;

            if(bellman_ford()){
                System.out.println(distance[V] == MAX ? "Impossible" : distance[V]);
            } else System.out.println("Never");

        }
    }

    // 에지 게수 탐색 및 노드 연결
    private static int getEdge(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(visited[tmp[0]][tmp[1]]) continue;

            visited[tmp[0]][tmp[1]] = true;

            for(int i = 0 ; i<4;++i){
                int nr = tmp[0] + dir[i][0];
                int nc = tmp[1] + dir[i][1];

                if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if(map[nr][nc] < 0 || visited[nr][nc]) continue;

                if(nr == H-1 && nc == W-1){
                    nodes.add(new Node(map[tmp[0]][tmp[1]], map[nr][nc], 1));
                    continue;
                }
                if(holeList.contains(map[nr][nc])){
                    nodes.add(new Node(map[tmp[0]][tmp[1]], map[nr][nc], 1));
                }
                else {
                    nodes.add(new Node(map[tmp[0]][tmp[1]], map[nr][nc], 1));
                    nodes.add(new Node(map[nr][nc], map[tmp[0]][tmp[1]], 1));
                }
                q.add(new int[]{nr, nc});

            }
        }
        return nodes.size();
    }

    private static boolean bellman_ford(){
//        boolean flag = false;
        for(int i = 1;i<=V;++i){
//            flag = true;
            for(int j = 0 ; j<B;++j){
                //Relax 과정을 수행해야 한다.
                if(distance[nodes.get(j).u] == MAX) continue;
                if(distance[nodes.get(j).v] > distance[nodes.get(j).u] + nodes.get(j).w) {
                    distance[nodes.get(j).v] = distance[nodes.get(j).u] + nodes.get(j).w;
//                    flag = false;
                }
            }

        }
//        if(flag) {
//            return true;
//        }
//        return false;
        for(int i = 0 ; i<B;++i){
            if (distance[nodes.get(i).v] > distance[nodes.get(i).u] + nodes.get(i).w) {
                return false;
            }
        }

        return true;
    }
}
