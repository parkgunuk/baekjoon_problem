import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> before = new HashMap<>();

        int[] exit = new int[N+1];

        for(int i = 1 ; i <= N ; ++i) before.put(br.readLine(), i);
        for(int i = 1 ; i <= N ; ++i) {
            String out = br.readLine();
            exit[i] = before.get(out);
        }

        int res = 0;


        for(int i = 1 ; i < N ; ++i){
            for(int j = i+1 ; j <= N ; ++j) {
                if (exit[i] > exit[j]) {
                    res++;
                    break;
                }
            }
        }

        System.out.println(res);
    }
}
