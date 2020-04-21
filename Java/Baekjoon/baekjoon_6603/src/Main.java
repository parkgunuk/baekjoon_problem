import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int[] arr;
    static boolean[] visited;
    static int cmd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        while(true){
            st = new StringTokenizer(br.readLine());
            cmd = stoi(st.nextToken());
            if(cmd == 0) break;

            arr = new int[cmd];
            visited = new boolean[cmd];

            for(int i = 0 ; i < cmd ; ++i) arr[i] = stoi(st.nextToken());

            rec(0,0);
            System.out.println();
        }
    }
    private static void rec(int s, int depth){
        if(depth==6){
            for(int i=0; i<cmd; i++){
                if(visited[i])
                    System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        for(int i=s; i<cmd; i++){
            visited[i] = true;
            rec(i+1,depth+1);
            visited[i] = false;
        }
    }
}
