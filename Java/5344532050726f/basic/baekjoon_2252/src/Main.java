import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[N+1];
        int[] tmp = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<=N;++i){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i<M;++i){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            tmp[b]++;
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
        System.out.println(sb);
    }
}
