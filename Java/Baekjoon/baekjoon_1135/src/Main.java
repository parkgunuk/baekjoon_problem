import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    static class Node implements Comparable<Node>{
        int val, idx;
        Node(int val, int idx){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return o.val-this.val;
        }
    }
    static int N;
    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new ArrayList[52];
        for(int i = 0 ; i<N;++i) tree[i] = new ArrayList<>();

        for(int i = 0 ; i < N ; ++i){
            int val = stoi(st.nextToken());
            if(val == -1) continue;
            tree[val].add(new Node(0,i));
        }

        System.out.println(DFS(0));
    }
    private static int DFS(int cur){
        int res = 0;
        for (int i = 0; i < tree[cur].size(); i++) {
            int next = tree[cur].get(i).idx;
            tree[cur].get(i).val = 1 + DFS(next);
        }

        // 부하에게 전화하는데 가장 오래 걸리는 순으로 정렬
        Collections.sort(tree[cur]);

        // 정렬된 순서대로 전화할때
        for (int i = 0; i < tree[cur].size(); i++) {
            tree[cur].get(i).val += i;
            res = Math.max(res, tree[cur].get(i).val);
        }

        return res;
    }
}
