import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    static class Node{
        int r, c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int M,N,K;
    static boolean[][] map, visited;
    static PriorityQueue<Integer> ans;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        map = new boolean[M+1][N+1];
        visited = new boolean[M+1][N+1];

        for(int i = 0 ; i<K;++i){
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());

            for(int j=x1; j<x2; j++) {
                for(int l=y1; l<y2; l++) {
                    map[l][j]=true;
                }
            }
        }

        Queue<Node> q;
        ans = new PriorityQueue<>();

        for(int i = 0 ; i < M ; ++i){
            for(int j = 0 ; j < N ; ++j){
                if(map[i][j] || visited[i][j]) continue;

                q = new LinkedList<>();
                q.add(new Node(i,j));
                visited[i][j] = true;

                int cnt = 0;
                while (!q.isEmpty()){
                    cnt++;

                    Node n = q.poll();
                    for(int k = 0 ; k<4;++k){
                        int nr = n.r+dir[k][0];
                        int nc = n.c+dir[k][1];

                        if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                        if(map[nr][nc] || visited[nr][nc]) continue;
                        q.add(new Node(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
                ans.add(cnt);
            }
        }
        if(ans.isEmpty()) System.out.println(0);
        else {
            System.out.println(ans.size());
            while (!ans.isEmpty()) System.out.print(ans.poll() + " ");
        }
    }
}
