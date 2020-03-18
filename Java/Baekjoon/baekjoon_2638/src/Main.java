import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int r, c;
        private Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    private static int N, M, res = 0, ans = 0;
    private static int[][] map, cheese, dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static Queue<Node> airQ, cheeseQ;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N+1][M+1];
        cheese = new int[N+1][M+1];

        airQ = new LinkedList<>();
        cheeseQ = new LinkedList<>();

        for(int r = 0 ; r < N ; ++r){
            st = new StringTokenizer(br.readLine());
            for (int c = 0 ; c < M ; ++c){
                map[r][c] = stoi(st.nextToken());
            }
        }

        while(true){
            getAir();

            while(!cheeseQ.isEmpty()){
                Node n = cheeseQ.poll();
                map[n.r][n.c] = 0;
            }
            res++;
            if(check()) break;

//            print();
//            System.out.println(ans+" "+res);
//            System.out.println("=====================================");
        }
        System.out.println(res);
//        System.out.println(ans);
    }

    private static void getAir(){
        boolean[][] visited = new boolean[N+1][M+1];

        airQ.add(new Node(0,0));
        visited[0][0] = true;

        while(!airQ.isEmpty()){
            Node n = airQ.poll();
            for(int i = 0 ; i < 4 ; ++i){
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if(visited[nr][nc])continue;

                if(map[nr][nc] == 1){
                    if(cheese[nr][nc] < 1) cheese[nr][nc]++;
                    else {
                        cheeseQ.add(new Node(nr, nc));
                        visited[nr][nc] = true;
                    }
                }

                if(map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    airQ.add(new Node(nr, nc));
                }
            }
        }

        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < M ; ++j){
                cheese[i][j] = 0;
                visited[i][j] = false;
            }
        }
    }

    private static boolean check(){
        int cnt = 0 ;
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < M ; ++j)
                if(map[i][j] == 1) cnt++;
        }
        if(cnt == 0) return true;
        else {
            ans = cnt;
            return false;
        }
    }

    private static void print(){
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < M ; ++j){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
