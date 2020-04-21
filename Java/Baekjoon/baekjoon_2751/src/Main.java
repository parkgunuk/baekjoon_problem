import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = stoi(br.readLine());
        while(N-->0) pq.add(stoi(br.readLine()));

        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
}
