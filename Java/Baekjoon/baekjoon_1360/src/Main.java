import java.io.*;
import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    private static class Node{
        char c;
        int time;

        private Node(char c, int time){
            this.c = c;
            this.time = time;
        }
    }

    private static int N;
    private static Stack<Node> stack, trash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        stack = new Stack<>();
        trash = new Stack<>();

        while(N-->0){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();


            if(cmd.equals("type")){
                char v = st.nextToken().toCharArray()[0];
                int time = stoi(st.nextToken());
                stack.push(new Node(v, time));
            } else {
                int time = stoi(st.nextToken());
                int cur = stoi(st.nextToken());

                while(true){
                    Node n = stack.peek();

                }
            }
        }
    }
}
