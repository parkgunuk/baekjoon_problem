import java.util.*;
public class Main {
    static long[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextLong();

        tree = new long[N];
        long max = Long.MIN_VALUE;
        long min = 0;
        for(int i = 0 ;i<N;++i) {
            tree[i] = sc.nextInt();
            max = max>tree[i] ? max : tree[i];
        }

        while(min<=max){
            long mid = (min+max)/2;
            long val = getTree(mid);

            if(val>=M) min = mid+1;
            else if(val<=M) max = mid-1;
        }

        System.out.println(max);
    }
    private static long getTree(long n){
        long res = 0;
        for(int i = 0; i<tree.length;++i){
            if(tree[i]>n) res+=(tree[i]-n);
        }
        return res;
    }
}
