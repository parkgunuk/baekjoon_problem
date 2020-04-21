import java.util.*;
import java.io.*;

public class Main {

    private static int pi[];
    private static int N,M;
    private static char[] input,pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();

        pi = new int[input.length];

        int j = 0;
        for(int i = 1; i<input.length; i++){
            while (j > 0 && input[i] != input[j]) j = pi[j-1];
            if(input[i] == input[j]) pi[i] = ++j;
        }

        //KMP 알고리즘
        LinkedList<Integer> list = new LinkedList<>();
        j = 0;

        for(int i = 0 ; i < input.length ; ++i){
            while (j > 0 && input[i] != pattern[j]) j = pi[j-1];

            if(input[i] == pattern[j]){
                if(j == pattern.length-1){
                    j = pi[j];
                    list.add(i-pattern.length+2);
                } else j++;
            }
        }

        System.out.println(list.size());
        for(int val : list) System.out.println(val);
    }
}
