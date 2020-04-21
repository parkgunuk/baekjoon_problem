import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = stoi(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N;++i) arr[i] = stoi(st.nextToken());

        Arrays.sort(arr);

        int M = stoi(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(M-->0){
            int ans = Arrays.binarySearch(arr, stoi(st.nextToken()));
            if(ans<0) System.out.print(0+" ");
            else System.out.print(1+" ");
        }
    }
}
