import java.util.*;
import java.io.*;

public class Main {
    static int[] A,B,C,D;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];
        long result = 0;

        for(int i = 0; i<N;++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N*N];
        Arrays.fill(AB, Integer.MAX_VALUE);
        HashMap<Integer, Integer> CD = new HashMap<>();
        for(int i =0;i<N;++i){
            for(int j = 0 ; j<N;++j){
                AB[i*N+j] = A[i] + B[j];
                int tmp = C[i] + D[j];
                if(CD.containsKey(tmp)) CD.replace(tmp, CD.get(tmp)+1);
                else CD.put(tmp,1);
            }
        }

        for (int i = 0; i < N*N; i++) {
            if(AB[i] == Integer.MAX_VALUE) break;

            int searchKey = -AB[i];
            if(CD.containsKey(searchKey)) {
                result += CD.get(searchKey);
            }
        }
        System.out.println(result);
    }
}
