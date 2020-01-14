import java.util.*;
import java.io.*;
public class Main {
    static int[] root;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        root = new int[n+1];
        for(int i = 0; i<n+1;++i){
            root[i] = i;
        }
        for(int i = 0 ; i<m;++i){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(cmd == 0)union(a,b);
            else {
                if(find(b) == find(a)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return;
        else root[b] = a;
    }
    private static int find(int a){
        if(root[a] == a) return a;
        return root[a] = find(root[a]);
    }
}
