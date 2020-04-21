import java.math.BigInteger;
import java.util.*;
        import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}

    static String[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int K = stoi(st.nextToken());
        int N = stoi(st.nextToken());
        A = new String[K+1];
        String choose="0", result;

        for(int i = 0; i < K; ++i){
            A[i] = br.readLine();
            if(choose.length() <= A[i].length() && stoi(choose) < stoi(A[i])) choose = A[i];
        }

        for(int i = 0; i < K-1; ++i) {
            for (int j = K - 2; j >= i; --j) {
                BigInteger a = new BigInteger(A[j + 1] + A[j]);
                BigInteger b = new BigInteger(A[j] + A[j + 1]);
                if (a.compareTo(b) > 0) swap(j, j + 1);
            }
        }

        int[] pos = new int[K];

        result = "";
        for(int i = 0; i < K; ++i){
            pos[i] = result.length();
            result += A[i];
        }

        if(N == 1) System.out.println(choose);
        else {
            for (int i = 0; i < K; ++i) {
                int j = pos[i];
                if (new BigInteger(result.substring(j, choose.length())).compareTo(new BigInteger(choose)) <= 0) {
                    sb.append(result.substring(0, j));
                    for (int k = 0; k < N - K; ++k) sb.append(choose);
                    sb.append(result.substring(j));
                    break;
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static void swap(int i, int j){
       String tmp = A[i];
       A[i] = A[j];
       A[j] = tmp;
    }
}
