import java.util.*;
public class Main {
    static class penwickTree{
        long[] tree;
        public penwickTree(int N){
            tree = new long[N+1];
        }

        public void add(int idx, long val){
            idx++;
            while(idx<tree.length){
                tree[idx] += val;
                idx += (idx & -idx);
            }
        }
        public long sum(int n){
            n++;
            long res = 0;
            while(n>0){
                res+=tree[n];
                n &= (n-1);
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        penwickTree tree = new penwickTree(N);

        long[] arr = new long[N];

        for(int i = 0 ; i<N;++i){
            arr[i] = sc.nextLong();
            tree.add(i,arr[i]);
        }
        String buff = sc.nextLine();

        for(int i = 0; i<M+K;++i){
            String[] str = sc.nextLine().split(" ");
            int cmd  = Integer.parseInt(str[0]);
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);

            if(cmd == 1){

                a -= 1;
                long diff = b - arr[a];
                arr[a] = b;
                tree.add(a,diff);

            } else {
                a -= 1;
                b -= 1;
                System.out.println(tree.sum(b) - tree.sum(a-1));
            }
        }
    }
}
