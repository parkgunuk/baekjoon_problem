import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    static int N;
    static int[] root;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = stoi(br.readLine());
        root = new int[N+1];
        tree = new ArrayList[N+1];
        for(int i = 0 ; i<= N ;++i) tree[i] = new ArrayList<>();

        for(int i = 1 ;i<N; ++i){
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()){
            int r = q.poll();

            for(int i : tree[r]){
                if(root[i] != 0) continue;
                root[i] = r;
                q.add(i);
            }
        }

        for(int i = 2; i<= N; ++i) System.out.println(root[i]);
    }
}
