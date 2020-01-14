import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String input){return Integer.parseInt(input);}
    static int W,H,G,E,X1,Y1,X2,Y2,T;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static class Node implements Comparable<Node>{
        int x,y;
        int cnt;
        int time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            cnt = 0;
            this.time = time;
        }
        public void hole(){
            cnt++;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine());
            W = stoi(st.nextToken());
            H = stoi(st.nextToken());
            boolean flag = false;

            if(W==0 && H == 0) break;

            int[][] map = new int[H][W];

            G = stoi(br.readLine());

            for(int i = 0 ; i<G;++i){
                st = new StringTokenizer(br.readLine());
                int r = stoi(st.nextToken());
                int c = stoi(st.nextToken());
                map[c][r] = -1;
            }
            E = stoi(br.readLine());

            for(int i = 0 ;i<E;++i){
                st = new StringTokenizer(br.readLine());
                X1 = stoi(st.nextToken());
                Y1 = stoi(st.nextToken());
                X2 = stoi(st.nextToken());
                Y2 = stoi(st.nextToken());
                T = stoi(st.nextToken());

                map[Y1][X1] = Integer.MAX_VALUE;
            }

            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(0,0,0));
            HashSet<String> set = new HashSet<>();
            set.add("0 0");

            int ans = Integer.MIN_VALUE;

            while (!q.isEmpty()){
                Node tmp = q.poll();

                if(tmp.y == H-1 && tmp.x == W-1) {
                    ans =tmp.time;
                    break;
                }

                if(map[tmp.y][tmp.x] == )
                for(int i = 0 ; i<4;++i){
                    int ny = tmp.y + dir[i][0];
                    int nx = tmp.x + dir[i][1];
                    String s = nx+" "+ny;

                    if(ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                    if(map[ny][nx] == -1) continue;
                    if(set.contains(s)) continue;

                    if(map[ny][nx] == Integer.MAX_VALUE){
                        if(tmp.cnt != 0) {
                            flag = true;
                            break;
                        }
                        else {
                            Node node = new Node(X2, Y2, tmp.time + 1 + T);
                            node.hole();
                            q.add(node);
                        }
                    }
                    else {
                        set.add(s);
                        q.add(new Node(nx,ny,tmp.time+1));
                    }
                }
            }
            if(ans == Integer.MIN_VALUE) System.out.println("Impossible");
            else {
                if (!flag)System.out.println(ans);
                else System.out.println("Never");
            }
        }
    }
}
