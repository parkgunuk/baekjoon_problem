import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; ++i) arr[i] = stoi(st.nextToken());

        int time = Integer.MAX_VALUE;

        for(int i = 1; i <= 1000; ++i){
            int tmp = 0;
            for(int j = 0; j < N; ++j)
                if(i+j*K != arr[j]) tmp++;
            time = Math.min(time, tmp);
        }

        System.out.println(time);
    }

}
