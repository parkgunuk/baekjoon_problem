import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = stoi(br.readLine());

        while(tc-->0){
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());
            int q = stoi(st.nextToken());
            int ans = 0;
            Queue<Integer> queue = new LinkedList<>();
            PriorityQueue<Integer> maxValue = new PriorityQueue<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ;i<N;++i){
                int a = stoi(st.nextToken());
                queue.add(a);
                maxValue.add(-a);
            }
            while(true){
                int val = queue.poll();
                if((maxValue.peek()*-1) == val) {
                    ans += 1;
                    if(q == 0) break;
                    else {
                        q--;
                        maxValue.poll();
                    }
                } else {
                    queue.add(val);
                    if(q == 0) q = queue.size()-1;
                    else q--;
                }
            }
            System.out.println(ans);
        }
    }
}
