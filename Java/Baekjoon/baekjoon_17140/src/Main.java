import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node implements Comparable<Node>{
        int num, cnt;
        private Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cnt == o.cnt) return this.num - o.num;
            return this.cnt - o.cnt;
        }
    }

    private static int r,c,k;
    private static int R,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
        k = stoi(st.nextToken());

        int time = 0;
        int res = -1;
        int[][] A = new int[101][101];

        for(int i = 0 ; i < 3 ; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3 ; ++j){
                A[i][j] = stoi(st.nextToken());
            }
        }

        R = 3;
        C = 3;

        while(time<=100){

            if(A[r-1][c-1] == k) {
                res = time;
                break;
            }

            int nr = R;
            int nc = C;

            time++;

            if(nr >= nc){
                for(int i = 0 ; i < nr ; ++i){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int j = 0 ; j < nc ; ++j) list.add(A[i][j]);
                    int[] tmp = sort(list, false);

                    for(int k = 0 ; k < 101 ; ++k) A[i][k] = tmp[k];
                }
            } else {
                for(int i = 0 ; i < nc ; ++i){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int j = 0 ; j < nr ; ++j) list.add(A[j][i]);

                    int[] tmp = sort(list, true);

                    for(int k = 0; k < 101 ; ++k) A[k][i] = tmp[k];
                }
            }
        }
        System.out.println(res);
    }

    private static int[] sort(ArrayList<Integer> list, boolean flag){ // flag가 false면 R>=C인 경우이다.

        PriorityQueue<Node> pq = new PriorityQueue<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = 0 ; i < list.size(); ++i){
            if(list.get(i) == 0) continue;

            if(map.containsKey(list.get(i))) map.put(list.get(i), map.get(list.get(i))+1);
            else map.put(list.get(i), 1);
        }

        for(int key : map.keySet()){
            pq.add(new Node(key, map.get(key)));
        }

        int idx = 0;
        int[] tmp = new int[101];
        while(!pq.isEmpty()){
            Node n = pq.poll();
            tmp[idx++] = n.num;
            tmp[idx++] = n.cnt;
        }

        if(flag) R = Math.max(R, idx);
        else C = Math.max(C, idx);

        return tmp;
    }
}