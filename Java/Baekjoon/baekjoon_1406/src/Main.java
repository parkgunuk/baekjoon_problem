import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] str = br.readLine().toCharArray();
        Stack<String> stack = new Stack<>();
        Stack<String> tmp = new Stack<>();

        int N = str.length;
        for(int i = 0 ; i<N;++i)stack.add(String.valueOf(str[i]));

        int M = stoi(br.readLine());
        int idx = N-1;
        int flag = 0;
        while(M-->0){
            String[] s = br.readLine().split(" ");
            String cmd = s[0];
            if(cmd.equals("L")){
                if(!stack.isEmpty()) tmp.push(stack.pop());
            } else if (cmd.equals("D")){
                if(!tmp.isEmpty()) stack.push(tmp.pop());
            } else if(cmd.equals("B")){
                if(!stack.isEmpty())stack.pop();
            } else {
                stack.push(s[1]);
            }
        }
        while(!stack.empty()) {
            tmp.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!tmp.isEmpty()) sb.append(tmp.pop());
        System.out.println(sb.toString());
    }
}
