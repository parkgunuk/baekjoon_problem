import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    static int N,K;
    static int[] w, v;
    static int[][] bag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        w = new int[N+1];
        v = new int[N+1];

        bag = new int[N+1][K+1];

        for(int i = 1 ; i <= N ; ++i){
            st = new StringTokenizer(br.readLine());
            w[i] = stoi(st.nextToken());
            v[i] = stoi(st.nextToken());
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=K;j++) {
                bag[i][j] = bag[i-1][j]; // 기본적으로 이전 아이템의 가치를 저장한다.
                if(j - w[i]>=0) { // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
                    bag[i][j] = Math.max(bag[i-1][j], bag[i-1][j-w[i]]+v[i]); // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
                }
            }
        }
        System.out.println(bag[N][K]);
    }
}
