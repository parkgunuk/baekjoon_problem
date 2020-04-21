import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static class FenwickTree{
        int[] tree;

        FenwickTree(int i){
            tree = new int[i];
        }

        void update(int i, int val){
            while (i < tree.length) {
                tree[i] += val;
                i += (i & -i);
            }

        }

        int getVal(int i){
            int ans = 0;
            while(i>0){
                ans+=tree[i];
                i -= (i&-i);
            }
            return ans;
        }
    }
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = stoi(br.readLine());

        while(T-->0){
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            n = stoi(st.nextToken());
            m = stoi(st.nextToken());
            int[] arr = new int[n+1];
            FenwickTree tree = new FenwickTree(n+m+1);

            for(int i = 1; i<=n;++i){
                arr[i] = i+m;
                tree.update(arr[i],1);
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i<m;++i){
                int idx = stoi(st.nextToken());
                sb.append(tree.getVal(arr[idx])-1 + " ");
                tree.update(arr[idx], -1);
                arr[idx] = m - i;
                tree.update(arr[idx], 1);
            }
            System.out.println(sb.toString());
        }
    }

}