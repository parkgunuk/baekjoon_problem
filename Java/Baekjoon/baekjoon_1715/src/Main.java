import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s); }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int i = 0 ; i< N; ++i) heap.add( stoi(br.readLine()));
        int ans = 0;
        while (heap.size()>1){
            int a = heap.poll();
            int b = heap.poll();

            ans += (a+b);
            heap.add((a+b));
        }

        System.out.println(ans);
    }
}
