import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static class Node implements Comparable<Node> {
        int abs, val;
        Node(int val){
            this.abs = Math.abs(val);
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if(this.abs == o.abs) return this.val - o.val;
            else return this.abs - o.abs;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int N = stoi(br.readLine());
        while(N-->0){
            int input = stoi(br.readLine());
            if(input == 0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll().val);
            } else {
                pq.add(new Node(input));
            }
        }
    }
}
