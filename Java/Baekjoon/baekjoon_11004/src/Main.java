import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(K);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;++i){
            int a = Integer.parseInt(st.nextToken());
            if(pq.size() < K) pq.add(-a);
            else{
                if(pq.peek() < -a){
                    pq.poll();
                    pq.add(-a);
                }
            }
        }
        System.out.println(-pq.poll());
    }
}
