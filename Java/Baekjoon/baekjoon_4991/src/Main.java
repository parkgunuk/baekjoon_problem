import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    private static class Node{
        int r, c, idx;

        private Node(int r, int c, int idx){
            this.r = r;
            this.c = c;
            this.idx = idx;
        }
    }

    private static int W, H;
    private static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = stoi(st.nextToken());
            H = stoi(st.nextToken());

            if(W == 0 && H ==0) break;
            map = new char[H][W];

            Deque<Node> q = new LinkedList<>();
            int idx = 1;

            for(int i = 0 ; i < H ; ++i){
                char[] foo = br.readLine().toCharArray();
                for(int j = 0 ; j < W ; ++j){
                    map[i][j] = foo[j];
                    if(map[i][j] == 'o') q.addFirst(new Node(i, j, 0));
                    else if(map[i][j] == '*') q.addLast(new Node(i, j, idx++));
                }
            }



        }
    }

    private static void calDist(int r, int c, int idx){

    }
}
