import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = stoi(st.nextToken());
        int S = stoi(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<N;++i) arr[i] = stoi(st.nextToken());


        System.out.println(ans);
    }
}
