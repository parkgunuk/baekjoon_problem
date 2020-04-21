import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = stoi(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(N);

        for(int r = 0; r<N;++r){
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ;c<N;++c){
                int input = stoi(st.nextToken());
                if(pq.size()<N) pq.add(input);
                else {
                    if(pq.peek() < input){
                        pq.poll();
                        pq.add(input);
                    } else continue;
                }
            }
        }
        System.out.println(pq.peek());
    }
}