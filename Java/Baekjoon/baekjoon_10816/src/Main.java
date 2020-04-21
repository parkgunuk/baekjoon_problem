import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        HashMap<Integer, Integer> dic = new HashMap<>();

        StringTokenizer st =new StringTokenizer(br.readLine());
        while(N-->0){
            int key = stoi(st.nextToken());
            if(dic.containsKey(key)) dic.replace(key, dic.get(key)+1);
            else dic.put(key, 1);
        }

        int M = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M-->0) {
            int key = stoi(st.nextToken());
            if(dic.containsKey(key)) {
                System.out.print(dic.get(key)+ " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}