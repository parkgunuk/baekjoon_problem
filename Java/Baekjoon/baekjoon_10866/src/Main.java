import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> deque = new LinkedList<>();

        int N = stoi(br.readLine());

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push_back")) deque.addLast(stoi(st.nextToken()));
            else if(cmd.equals("push_front")) deque.addFirst(stoi(st.nextToken()));
            else if(cmd.equals("pop_back")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollLast());
            }
            else if(cmd.equals("pop_front")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.pollFirst());
            }
            else if(cmd.equals("size")) System.out.println(deque.size());
            else if(cmd.equals("empty")){
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(cmd.equals("front")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekFirst());
            }
            else if(cmd.equals("back")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
            }
        }

    }
}