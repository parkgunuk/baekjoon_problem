import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}

    static int N, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        C = stoi(st.nextToken());

        long[] homes = new long[N];
        for(int i = 0 ; i<N;++i)homes[i] = stol(br.readLine());

        Arrays.sort(homes);

        long left = 1;
        long right = homes[N-1] - homes[0];

        long result = 0;

        while (left<=right){
            long mid = (left + right) /2;
            int cnt =1;
            long start = homes[0];

            for (int i = 1; i < N; i++) {
                if (homes[i] - start >= mid){
                    cnt++;
                    start = homes[i];
                }
            }

            if (cnt >= C){  //너무 간격이 가까워 공유기가 많이 설치되거나 or 더 가까운 최소 거리가 있을 수 있음
                left = mid+1;
                result = mid;
            }else   //너무 간격이 멀어 설치 갯수가 부족한 경우
                right = mid -1;
        }
        System.out.println(result);
    }
}

