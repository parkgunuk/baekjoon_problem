import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int N, cnt;
    static int[] arr;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = stoi(br.readLine());

        while(T-->0){
            N = stoi(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i<=N;++i) arr[i] = stoi(st.nextToken());

            cnt = 0;

            for(int i = 1; i<=N;++i) isLoop(i);


            System.out.println(N - cnt);

        }
    }
    private static void isLoop(int cur){
        if(visited[cur])
            return;

        visited[cur] = true;
        int next = arr[cur];

        if(visited[next] != true)
            isLoop(next);
        else {
            if(finished[next] != true) {
                // 노드가 끝나려면 싸이클을 무조건 거쳐야한다.
                // 따라서 현재 노드가 아닌 다음 노드 기준으로 하면 싸이클이 무조건 존재
                cnt++;
                for(int i=next; i != cur; i = arr[i])
                    cnt++;
            }
        }

        // 모든 작업이 끝나서 더이상 사용하지 않음
        finished[cur] = true;
    }
}
