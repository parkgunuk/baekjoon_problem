import java.util.*;
public class Main {
    static class penwickTree{
        long[] tree;

        public penwickTree(int n) {
            tree = new long[n+1];
        }

        public void update(int idx, long val){
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
            tree.update(i,arr[i]);
        }
        sc.nextLine();

        for(int i = 0 ;i <M+K;++i){
            String[] t = sc.nextLine().split(" ");
            int cmd = Integer.parseInt(t[0]);
            int b = Integer.parseInt(t[1]);
            int c = Integer.parseInt(t[2]);

            if(cmd == 1) {
                tree.update(b-1,c-arr[b-1]);
                arr[b-1] = c;
            }
            else System.out.println(tree.sum(c-1) - tree.sum(b-2));

        }
    }
}
