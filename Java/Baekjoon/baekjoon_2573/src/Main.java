import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int r, c;
        private Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, year;
    static int[][] map, dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static Queue<Node> iceberg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N][M];
        year = 0;
        iceberg = new LinkedList<>();

        for(int i = 0 ; i<N;++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<M;++j){
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] > 0) iceberg.add(new Node(i,j));
            }
        }

        while(getIceberg()){
            removeIceberg();
            print();
        }
        System.out.println(year);
    }
    private static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<N;++i){
            for(int j = 0 ;j<M;++j){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static void removeIceberg(){
        year++;
        int size = iceberg.size();
        Queue<Integer> q = new LinkedList<>();

        while(size-->0){
            Node n = iceberg.poll();
            int cnt = 0;
            for(int i = 0 ; i<4;++i){
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(map[nr][nc] == 0) cnt++;
            }
            q.add(cnt);
            iceberg.add(n);
        }
        while(!q.isEmpty()){
            int diff = q.poll();
            Node n = iceberg.poll();
            map[n.r][n.c] -= diff;
            if(map[n.r][n.c] > 0 ) iceberg.add(n);
            else map[n.r][n.c] = 0;
        }
    }

    private static boolean getIceberg(){
        int iceberg = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for(int i = 0 ;i<N;++i){
            for(int j = 0 ; j<M;++j){
                if(map[i][j] != 0 && !visited[i][j]){
                    q.add(new Node(i,j));
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        Node n = q.poll();
                        for(int k = 0 ; k <4;++k){
                            int nr = n.r + dir[k][0];
                            int nc = n.c + dir[k][1];
                            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                            if(visited[nr][nc] || map[nr][nc] == 0) continue;

                            q.add(new Node(nr,nc));
                            visited[nr][nc] = true;
                        }
                    }
                    iceberg++;
                }
            }
        }
        if(iceberg > 1) return false;
        else {
            int cnt = 0;
            for(int i = 0 ; i<N;++i){
                for(int j = 0 ; j<M;++j){
                    if(map[i][j] == 0){
                        cnt++;
                    }
                }
            }
            if(cnt == N*M) {
                year = 0;
                return false;
            }
            return true;
        }
    }
}
