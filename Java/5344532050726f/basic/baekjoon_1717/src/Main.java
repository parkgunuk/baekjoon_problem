import java.util.*;
public class Main {
    static int[] root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();

        root = new int[N+1];
        for(int i = 0; i<=N;++i){
            root[i] = i;
        }

        for(int i = 0; i<M;++i){
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(cmd == 0) union(a,b);
            else {
                if(find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;
        root[b] = a;
    }
    private static int find(int val){
        if(root[val] == val) return val;
        return root[val] = find(root[val]);
    }
}
