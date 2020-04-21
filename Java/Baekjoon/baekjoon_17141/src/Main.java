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

    private static int N, M, res = Integer.MAX_VALUE, zero;
    private static int[][] map, tmp, dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    private static ArrayList<Node> list;
    private static ArrayList<Integer> virus;
    private static boolean[] visited;
    private static boolean[][] isVirus;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        zero = 0;

        map = new int[N+1][N+1];
        tmp = new int[N+1][N+1];
        list = new ArrayList<>();
        virus = new ArrayList<>();

        for(int r = 0 ; r < N ; ++r){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < N ; ++c){
                map[r][c] = stoi(st.nextToken());
                if(map[r][c] == 2) list.add(new Node(r,c));
                if(map[r][c] == 0) zero++;
            }
        }
        visited = new boolean[list.size()+1];
        if(zero>0)getNextPermu(0);
        else res = 0;

        if(res != Integer.MAX_VALUE)System.out.println(res);
        else System.out.println(-1);
    }

    private static void getNextPermu(int cnt){
        if(cnt == M) {
            copyNewMap();
            int count = 0;
            Queue<Node> q = new LinkedList<>();
            for(int i : virus) q.add(list.get(i));
            while(true) {
//                print();
//                System.out.println(count);
//                System.out.println("==================================");

                int qSize = q.size();
                if (qSize == 0) break;

                while (qSize-- > 0) {
                    Node n = q.poll();
                    for (int i = 0; i < 4; ++i) {
                        int nr = n.r + dir[i][0];
                        int nc = n.c + dir[i][1];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if ((tmp[nr][nc] == 0 || tmp[nr][nc] == 2) && !isVirus[nr][nc]) {
                            isVirus[nr][nc] = true;
                            tmp[nr][nc] = 2;
                            q.add(new Node(nr,nc));
                        }
                    }
                }
                count++;
                if(check())break;
            }
            if (res > count && check()) res = count;

        }

        for(int i = 0; i < list.size(); ++i){
            if(visited[i]) continue;
            if(virus.size() > 0 && virus.get(virus.size()-1) > i) continue;

            visited[i] = true;
            virus.add(i);
            getNextPermu(cnt+1);
            virus.remove(virus.size()-1);
            visited[i] = false;

        }
    }

    private static void copyNewMap(){
        tmp = new int[N+1][N+1];
        isVirus = new boolean[N+1][N+1];

        for(int r = 0 ; r < N ; ++r){
            for(int c = 0 ; c < N ; ++c){
                tmp[r][c] = map[r][c];
                if (tmp[r][c] == 2) isVirus[r][c] = true;
            }
        }

        for(int i = 0 ; i < list.size(); ++i){
            if(virus.contains(i)) continue;
            Node n = list.get(i);
            isVirus[n.r][n.c] = false;

        }

    }

    private static void print(){
        for(int r = 0 ; r < N ; ++r) {
            for (int c = 0; c < N; ++c) {
                System.out.print(tmp[r][c]+" ");
            }
            System.out.println();
        }
    }
    private static void print(boolean[][] t){
        for(int r = 0 ; r < N ; ++r) {
            for (int c = 0; c < N; ++c) {
                System.out.print(t[r][c]+" ");
            }
            System.out.println();
        }
    }

    private static boolean check(){
        for(int r = 0 ; r < N ; ++r){
            for(int c = 0 ; c < N ; ++c){
                if(tmp[r][c] == 0) return false;
            }
        }
        return true;
    }
}
