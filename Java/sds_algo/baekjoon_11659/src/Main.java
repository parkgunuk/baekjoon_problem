import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] dp = new int[N+1];
        int[] arr= new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N;++i) {
            arr[i] = stoi(st.nextToken());
            dp[i] = dp[i-1]+arr[i];
        }


        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            System.out.println((dp[stoi(st.nextToken())-1]-dp[stoi(st.nextToken())])*-1);
        }
    }
}
