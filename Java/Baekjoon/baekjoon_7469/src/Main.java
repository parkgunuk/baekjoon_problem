import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    static class Node implements Comparable<Node>{
        int idx, val;
        Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
        @Override
        public int compareTo(Node o) {
            return this.val-o.val;
        }
    }
    static int N, M;
    static Node[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        list = new Node[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; ++i) list[i] = new Node(i+1, stoi(st.nextToken()));
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int i = stoi(st.nextToken());
            int j = stoi(st.nextToken());
            int k = stoi(st.nextToken());

            bw.write(query(i,j,k)+"\n");
        }
        bw.close();
    }
    private static int query(int i, int j, int k){
        int cnt = 0;
        for(int l = 0 ; l<N;++l){
            if( i <= list[l].idx && list[l].idx <= j) cnt++;
            if(cnt == k) return list[l].val;
        }
        return -1;
    }
}
