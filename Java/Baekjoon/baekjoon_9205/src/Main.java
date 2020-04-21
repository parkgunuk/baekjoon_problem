import java.io.*;
import java.util.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static class Node{
        int x, y;
        private Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = stoi(br.readLine());
        while(T-->0){
            N = stoi(br.readLine());
            boolean flag = false;
            int[][] dist = new int[N + 2][N + 2];
            int[] chk = new int[N + 2];
            Node[] nodes = new Node[N + 2];
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(stoi(st.nextToken()), stoi(st.nextToken()));
            }
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    dist[i][j] = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y);
                }
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            chk[0] = 1;
            while (!queue.isEmpty()) {
                int now = queue.poll();
                if (now == N + 1) {
                    flag = true;
                    break;
                }
                for (int i = 0; i < N + 2; i++) {
                    if (chk[i] == 0 && now != i && dist[now][i] <= 1000) {
                        chk[i] = 1;
                        queue.offer(i);
                    }
                }
            }
            String ans = flag ? "happy" : "sad";
            System.out.println(ans);

        }
    }
}
