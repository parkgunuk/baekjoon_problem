import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static int N, K, w;
    private static int[] time, indegree;
    private static ArrayList<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = stoi(br.readLine());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            K = stoi(st.nextToken());
            time = new int[N+1];
            list = new ArrayList[N+1];

            for(int i = 0 ; i <= N ; ++i) list[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++)
                time[i] = Integer.parseInt(st.nextToken());

            indegree = new int[N+1];

            for(int i = 0 ; i < K ; ++i){
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());

                list[a].add(b);
                indegree[b]++;
            }
            w = Integer.parseInt(br.readLine());
            solution();
        }
    }
    private static void solution(){
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N+1];

        for(int i = 1; i <= N; i++) {
            result[i] = time[i];

            if(indegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(Integer i : list[node]) {
                result[i] = Math.max(result[i], result[node] + time[i]);
                indegree[i]--;

                if(indegree[i] == 0)
                    q.add(i);
            }
        }

        System.out.println(result[w]);
    }

}
