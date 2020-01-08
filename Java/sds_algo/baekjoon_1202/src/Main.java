import java.util.*;

public class Main {
    static class jewelry implements Comparable<jewelry>{
        long m;
        long v;

        jewelry(long m, long v){
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(jewelry o) {
            if(this.m>o.m) return 1;
            else return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        jewelry[] jewelList = new jewelry[N];
        long[] bagList = new long[K];

        for(int i = 0 ; i<N;++i) jewelList[i] = (new jewelry(sc.nextLong(), sc.nextLong()));
        for(int i = 0 ; i<K;++i) bagList[i] = (sc.nextLong());

        long res = 0;
        Arrays.sort(jewelList);
        Arrays.sort(bagList);

        for(int i =  0 , j =0; i<K;++i){
            while(j<N && jewelList[j].m <= bagList[i]) pq.add((jewelList[j++].v)*-1);
            if (!pq.isEmpty()) res += (pq.poll()*-1);
        }

        System.out.println(res);
    }
}
