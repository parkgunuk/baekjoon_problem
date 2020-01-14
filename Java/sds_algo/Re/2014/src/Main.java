import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] primeNum = new long[K];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<K;++i) {
            primeNum[i] = Long.parseLong(st.nextToken());
            pq.add(primeNum[i]);
        }
        long ans = 0;

        for (int i = 0; i < N; i++) {
            ans = pq.poll();

            for (int j = 0; j < K; j++) {
                long value = ans * primeNum[j];
                pq.add(value);

                if (ans % primeNum[j] == 0) {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
