import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        int val, lev;

        private Node(int val, int lev){
            this.val = val;
            this.lev = lev;
        }
    }

    private static final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int N;
    private static Node[][] adj;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());

        adj = new Node[N][2*N];

        int lev = 1;

        for(int i = 0 ; i < N ; ++i){
            if(i % 2 == 0){ // N개일경우
                for(int j = 0 ; j < 2*N ; j+=2){
                    st = new StringTokenizer(br.readLine());
                    adj[i][j] = new Node(stoi(st.nextToken()), lev);
                    adj[i][j+1] = new Node(stoi(st.nextToken()), lev);
                    lev++;
                }
            } else {
                adj[i][0] = new Node(0,0);
                adj[i][2*N-1] = new Node(0,0);

                for(int j = 1 ; j < 2*N-1 ; j+=2){
                    st = new StringTokenizer(br.readLine());
                    adj[i][j] = new Node(stoi(st.nextToken()), lev);
                    adj[i][j+1] = new Node(stoi(st.nextToken()), lev);
                    lev++;
                }
            }
        }

        ArrayList<Integer>[] list = new ArrayList[N * N];
        for(int i = 0 ; i < N * N ; ++i ) list[i] = new ArrayList<>();

        for(int i = 0 ; i < N ; ++i){
            for(int j = 0 ; j < 2 * N ; ++j){
                int now = adj[i][j].lev;

                for (int k = 0 ; k < 4; ++k) {
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= 2 * N) continue;

                    int next = adj[nr][nc].lev;
                    if (now != next && adj[i][j].val == adj[nr][nc].val) {
                        list[now].add(next);
                    }
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] visited = new boolean[N*N];
        visited[1] = true;

        int ans = 0;
        int[] path = new int[N*N];

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nx : list[cur]) {
                if (visited[nx]) continue;
                if (ans < nx) ans = nx;
                visited[nx] = true;
                path[nx] = cur;
                q.add(nx);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        int x = ans;

        res.add(x);
        while (path[x] > 0) {
            x = path[x];
            res.add(x);
        }
        StringBuilder sb = new StringBuilder();
        int len = res.size();

        for (int i=0; i<len; i++) sb.append(res.get(len-i-1) + " ");

        System.out.println(len);
        System.out.println(sb.toString().trim());
    }
}