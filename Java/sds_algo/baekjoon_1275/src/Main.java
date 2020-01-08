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
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int Q = sc.nextInt();

        penwickTree tree = new penwickTree(N);
        long[] arr = new long[N];

        for(int i = 0 ; i<N;++i){
            arr[i] = sc.nextLong();
            tree.update(i,arr[i]);
        }
        sc.nextLine();
        while(Q-->0){
            String[] t = sc.nextLine().split(" ");
            int x = Integer.parseInt(t[0]);
            int y = Integer.parseInt(t[1]);
            int a = Integer.parseInt(t[2]);
            int b = Integer.parseInt(t[3]);

            if(x>y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            sb.append(tree.sum(y-1)-tree.sum(x-2)+"\n");
            tree.update(a-1, b-arr[a-1]);
            arr[a-1] = b;

        }
        System.out.println(sb.toString());
    }
}
