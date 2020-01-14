import java.io.*;
import java.util.*;
public class Main {
    static String[] inputs;
    static int N, ans=Integer.MIN_VALUE;
    static char[] arr;
    static int[] value;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        inputs = new String[N];
        value = new int[26];
        checked = new boolean[10];

        HashSet<Character> inputChar = new HashSet<>();
        for(int i = 0 ;i<N;++i) inputs[i] = br.readLine();

        for(int i = 0 ; i<N;++i){
            for(char c : inputs[i].toCharArray()){
                inputChar.add(c);
            }
        }
        arr = new char[inputChar.size()];
        int idx = 0;
        for(char c : inputChar){
            arr[idx++] = c;
        }
        backtracking(0);
        System.out.println(ans);
    }
    private static void backtracking(int n){
        if(n >= arr.length){
            int a = cal();
            ans = ans>a?ans:a;
            return;
        } else {
            for(int i = 9 ; i>=0;--i){
                if(!checked[i]){
                    checked[i] = true;
                    value[arr[n]-'A'] = i;
                    backtracking(n+1);
                    checked[i] = false;
                }
            }
        }
    }
    private static int cal(){
        int res =0;
        for(int i = 0 ;i<N;++i){
            char[] tmp = inputs[i].toCharArray();
            int tamp = 0;
            for(char c : tmp){
                tamp *= 10;
                tamp += value[c-'A'];
            }
            res += tamp;
        }
        return res;
    }
}
