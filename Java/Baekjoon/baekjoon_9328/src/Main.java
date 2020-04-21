import java.io.*;
        import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int h,w;
        private Node(int h, int w){
            this.h = h;
            this.w = w;
        }
    }

    private static boolean[][] visited;
    private static boolean[] hasKey;
    private static char[][] map;
    private static int H, W, res;

    private static int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = stoi(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            H = stoi(st.nextToken());
            W = stoi(st.nextToken());
            res = 0;

            visited = new boolean[H+2][W+2];
            hasKey = new boolean[26];
            map = new char[H+2][W+2];

            for(int h = 1 ; h <= H ; ++h){
                char[] tmp = br.readLine().toCharArray();
                for(int w = 1 ; w <= W ; ++w){
                    map[h][w] = tmp[w-1];
                }
            }

            for (int i = 0; i <= W + 1; i++) {
                map[0][i] = '.';
                map[H + 1][i] = '.';
            }

            for (int i = 0; i <= H + 1; i++) {
                map[i][0] = '.';
                map[i][W + 1] = '.';
            }

            String str = br.readLine();
            if(!str.equals("0")) {
                char[] c = str.toCharArray();
                for (char cc : c) hasKey[cc - 'a'] = true;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0,0));
            visited[0][0] = true;

            while(!q.isEmpty()){
                Node tmp = q.poll();
                for(int i = 0 ; i < 4 ; ++i){
                    int nh = tmp.h + dir[i][0];
                    int nw = tmp.w + dir[i][1];

                    if(nh < 0 || nh >=  H+2 || nw < 0 || nw >= W+2) continue;
                    if(visited[nh][nw] || map[nh][nw] == '*') continue;

                    // 문서가 있으면 합계에 누적해줌
                    if (map[nh][nw] == '$') {
                        res++;
                        map[nh][nw] = '.';
                    }

                    // 문일 때 열쇠를 가지고 있으면 열수 있음
                    if (map[nh][nw] >= 'A' && map[nh][nw] <= 'Z') {
                        if (hasKey[map[nh][nw] - 'A']) map[nh][nw] = '.';
                    }

                    // 빈 공간이고 방문하지 않았으면 큐에넣음
                    if (map[nh][nw] == '.' && !visited[nh][nw]) {
                        q.add(new Node(nh, nw));
                        visited[nh][nw] = true;
                    }

                    // 키가 있으면 키 배열에 체크
                    if (map[nh][nw] >= 'a' && map[nh][nw] <= 'z') {
                        hasKey[map[nh][nw] - 'a'] = true;
                        map[nh][nw] = '.';

                        // 키 찾았으니까 큐와 visited 배열 초기화하고 다시 탐색
                        q.clear();
                        for(int h = 0 ; h <= H+1 ; ++h){
                            for(int w = 0 ; w <= W+1 ; ++w){
                                visited[h][w] = false;
                            }
                        }
                        q.add(new Node(0,0));
                        visited[0][0] = true;
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
