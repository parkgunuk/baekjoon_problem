import java.util.*;
        import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node {
        int r, c;
        private Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }


    private static int N, M;
    private static int[][] dist, map, dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for(int i = 0 ; i < N ; ++i) Arrays.fill(dist[i], 987654321);

        for(int i = 0 ; i < N ; ++i){
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0 ; j < M ; ++j){
                map[i][j] = tmp[j] - '0';
            }
        }

        Deque<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        dist[0][0] = 0;

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while(!q.isEmpty()){
            Node n = q.poll();

            for(int i = 0 ; i < 4 ; ++i){
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if( nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;

                if(map[nr][nc] == 1){
                    dist[nr][nc] = dist[n.r][n.c] +1;
                    q.add(new Node(nr, nc));
                } else {
                    dist[nr][nc] = dist[n.r][n.c];
                    q.addFirst(new Node(nr, nc));
                }
            }
        }

        System.out.println(dist[N-1][M-1] == 987654321 ? 0 : dist[N-1][M-1]);
    }
}
