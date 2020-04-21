import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int N;
    static int[] arr, tailTable;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0 ; i<N;++i) arr[i] = stoi(st.nextToken());

        System.out.println(LSI());
    }
    private static int LSI(){
        tailTable = new int[N];
        int lisLen = 0;

        tailTable[0] = arr[0];
        lisLen = 1;

        for(int i = 1;i<N;++i){
            // 후보 값이 lis의 처음보다 작으면?
            if(arr[i] < tailTable[0]) tailTable[0] = arr[i];

            // 후보 값이 lis의 마지막보다 크면?
            if(arr[i] > tailTable[lisLen-1]) tailTable[lisLen++] = arr[i];
            else {
                int idx = Arrays.binarySearch(tailTable, 0, lisLen, arr[i]);
                idx = idx < 0 ? -idx-1:idx;
                tailTable[idx] = arr[i];
            }
        }

        return lisLen;
    }
}
