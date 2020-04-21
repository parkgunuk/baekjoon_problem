import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ans = new int[10];

        int start = 1;
        int point = 1;
        while(start <= N){
            // N의 끝자리를 9로 만들기
            while(N%10 != 9 && start <= N){
                cal(N, point);
                N--;
            }
            if (N < start) break;
            //끝자리 0으로 만들기
            while(start%10 != 0 && start<=N){
                cal(start,point);
                start++;
            }
            start /= 10;
            N /= 10;

            for(int i = 0 ; i <10;++i) ans[i] += (N-start+1)*point;
            point*=10;
        }

        for(int i : ans) System.out.print(i+" ");
    }

    private static void cal(int val, int point){
        while(val>0){
            ans[val%10]+= point;
            val/=10;
        }
    }
}
