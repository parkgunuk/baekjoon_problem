import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tmp = new int[N+1];
        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i = 0;i<=N;++i){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            tmp[B]++;
        }

        for(int i = 1; i<=N;++i) {
            if (tmp[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int answer = q.poll();
            sb.append(answer + " ");

            for(int i = 0; i<list[answer].size();++i){
                int idx = list[answer].get(i);
                tmp[idx]--;
                if(tmp[idx] == 0 ) q.add(idx);
            }

        }
        System.out.println(sb.toString().trim());
    }
}
