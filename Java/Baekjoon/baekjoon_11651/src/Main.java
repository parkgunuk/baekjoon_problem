import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static class Node implements Comparable<Node>{
        int x, y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if(this.y == o.y) return this.x - o.x;
            else return this.y - o.y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = stoi(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        while (!pq.isEmpty()){
            Node tmp = pq.poll();
            System.out.println(tmp.x+" "+tmp.y);
        }
    }
}
