import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N;
    static int[] inorder, postorder, inorderIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());

        inorder = new int[N];
        inorderIdx = new int[N+1];
        postorder = new int[N];

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            int val = stoi(st.nextToken());
            inorder[i++] = val;
            inorderIdx[val] = i;
        }

        st = new StringTokenizer(br.readLine());
        i = 0;
        while(st.hasMoreTokens()) postorder[i++] = stoi(st.nextToken());

        getPreorder(0, N-1, 0, N-1);
    }

    private static void getPreorder(int l, int r, int ll, int rr){
        if (l > r) return;

        if (l == r) {
            System.out.print(inorder[l] + " ");
            return;
        }

        int node = postorder[rr];
        System.out.print(node + " ");

        int index = inorderIdx[node] - 1;

        getPreorder(l, index - 1, ll, rr + (index - 1 - r));
        getPreorder(index + 1, r, ll + (index - l), rr - 1);

        return;
    }
}
