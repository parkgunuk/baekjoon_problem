import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node> {
        int r, c, time, color;

        private Node(int r, int c, int time, int color){
            this.r = r;
            this.c = c;
            this.time = time;
            this.color = color;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    private static int N, M, G, R, res = -1;
    private static int[][] map, dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static boolean[] checked;

    private static ArrayList<Node> possibleList;
    private static ArrayList<Node> RList;
    private static ArrayList<Node> GList;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        G = stoi(st.nextToken());
        R = stoi(st.nextToken());

        map = new int[N][M];

        possibleList = new ArrayList<>();
        RList = new ArrayList<>();
        GList = new ArrayList<>();

        for(int r = 0 ; r < N ; ++r){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; ++c){
                map[r][c] = stoi(st.nextToken());
                if(map[r][c] == 2) possibleList.add(new Node(r,c,0,0));

            }
        }

        checked = new boolean[possibleList.size()+1];
        getPermu(0,R,G);
        System.out.println(res);
    }

//    private static void GPermu(int idx){
//        if(idx == G){
//            RPermu(0);
//        }
//
//        for(int i = 0 ; i < possibleList.size(); ++i){
//            if(checked[i]) continue;
//
//            checked[i] = true;
//            Node n = possibleList.get(i);
//            GList.add(new Node(n.r, n.c, 1, 1));
//            GPermu(idx+1);
//            GList.remove(GList.size()-1);
//            checked[i] = false;
//        }
//    }
//
//    private static void RPermu(int idx){
//        if(idx == R){
//            BFS();
//        }
//
//        for(int i = 0 ; i < possibleList.size(); ++i){
//            if(checked[i]) continue;
//            checked[i] = true;
//            Node n = possibleList.get(i);
//            RList.add(new Node(n.r, n.c, 1, 2));
//            RPermu(idx+1);
//            RList.remove(RList.size()-1);
//            checked[i] = false;
//        }
//    }

    private static void getPermu(int idx, int red, int green){
        if (red == 0 && green == 0) {
            if (RList.size() > 0 && GList.size() > 0) BFS();
            return;
        }

        if(idx >= possibleList.size()) return;

        for (int i = idx; i < possibleList.size(); i++) {
            Node n = possibleList.get(i);
            if (red > 0) {
                RList.add(new Node(n.r, n.c, 1, 2));
                getPermu(i + 1, red - 1, green);
                RList.remove(RList.size()-1);
            }
            if (green > 0) {
                GList.add(new Node(n.r, n.c, 1,1));
                getPermu(i + 1, red, green - 1);
                GList.remove(GList.size()-1);
            }
        }
    }

    private static void BFS(){

        Node[][] tmp = new Node[N][M];
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0; j < M ; ++j){
                tmp[i][j] = new Node(i,j,0,0);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Node n : GList){
            pq.add(new Node(n.r, n.c, n.time, n.color));
            tmp[n.r][n.c].time = n.time;
            tmp[n.r][n.c].color = n.color;
        }
        for(Node n : RList){
            pq.add(new Node(n.r, n.c, n.time, n.color));
            tmp[n.r][n.c].time = n.time;
            tmp[n.r][n.c].color = n.color;
        }

        int cnt = 0;

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(tmp[n.r][n.c].color == 3 ) continue;

            for(int i = 0 ; i < 4 ; ++i){
                int nr = n.r + dir[i][0];
                int nc = n.c + dir[i][1];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) continue;

                if(tmp[nr][nc].color == 0){
                    tmp[nr][nc].color = n.color;
                    tmp[nr][nc].time = n.time+1;
                    pq.add(new Node(nr, nc, n.time+1, n.color));
                } else if(tmp[nr][nc].color == 1){
                    if(tmp[nr][nc].time == n.time+1 && n.color == 2) {
                        tmp[nr][nc].color = 3;
                        cnt++;
                    }
                } else if(tmp[nr][nc].color == 2){
                    if(tmp[nr][nc].time == n.time+1 && n.color == 1){
                        tmp[nr][nc].color = 3;
                        cnt++;
                    }
                }
            }
//            System.out.println();
//            printColor(tmp);
//            System.out.println();
//            printTime(tmp);
//            System.out.println("===============================");
        }
//        System.out.println();
//        printColor(tmp);
//        System.out.println();
//        printTime(tmp);
//        System.out.println("===============================");
        res = Math.max(res, cnt);
    }

    private static void printColor(Node[][] t){
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < M; ++j){
                System.out.print(t[i][j].color + " ");
            }
            System.out.println();
        }
    }
    private static void printTime(Node[][] t){
        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < M; ++j){
                System.out.print(t[i][j].time + " ");
            }
            System.out.println();
        }
    }
}
