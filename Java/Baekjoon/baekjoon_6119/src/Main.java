import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        Deque<Integer> deque = new ArrayDeque<>();

        int idx = 1;
        for(int i = 0 ; i < N ; ++i){
            st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("A")){
                String dir = st.nextToken();

                if(dir.equals("L")) deque.addFirst(idx++);
                else deque.addLast(idx++);
            } else {
                String dir = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                while(val-->0){
                    if(dir.equals("L")) deque.pollFirst();
                    else deque.pollLast();
                }
            }
        }
        while(!deque.isEmpty()){
            System.out.println(deque.pollFirst());
        }
    }
}
