import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        while(T-->0) {
            Stack<String> stack = new Stack<>();
            Stack<String> tmp = new Stack<>();
            String[] str = br.readLine().split("");
            int N = str.length;

            for (int i = 0; i<N;++i) {
                String cmd = str[i];

                if (cmd.equals("<")) {
                    if (!stack.isEmpty()) tmp.push(stack.pop());
                } else if (cmd.equals(">")) {
                    if (!tmp.isEmpty()) stack.push(tmp.pop());
                } else if (cmd.equals("-")) {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(str[i]);
                }
            }
            while (!stack.empty()) {
                tmp.push(stack.pop());
            }

            StringBuilder sb = new StringBuilder();
            while (!tmp.isEmpty()) sb.append(tmp.pop());
            System.out.println(sb.toString());
        }
    }
}
