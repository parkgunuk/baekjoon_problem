import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    private static long stol(String s){return Long.parseLong(s);}
    static int N, lisLen;
    static long[] arr, tailTable;
    static ArrayList<long[]> pii;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        pii = new ArrayList<>();

        for(int i = 0 ; i<N;++i) arr[i] = stol(st.nextToken());

        System.out.println(LSI());
        StringBuilder sb = new StringBuilder();
        Stack<Long> s = new Stack<>();

        int t = lisLen;
        for (int i = pii.size()-1; i >= 0; i--) {
            if (pii.get(i)[0] == t) {
                s.add(pii.get(i)[1]);
                t--;
            }
        }

        while (!s.empty()) {
            sb.append(s.pop()+" ");
        }
        System.out.println(sb.toString().trim());

    }

    private static int LSI(){
        tailTable = new long[N];
        lisLen = 0;

        tailTable[0] = arr[0];
        pii.add(new long[] {0,tailTable[0]});

        for(int i = 1;i<N;++i){
            if(arr[i] > tailTable[lisLen]){
                tailTable[++lisLen] = arr[i];
                pii.add(new long[] {lisLen, arr[i]});
            }
            else {
                int idx = Arrays.binarySearch(tailTable, 0, lisLen, arr[i]);
                idx = idx < 0 ? -idx-1:idx;
                tailTable[idx] = arr[i];

                pii.add(new long[] {idx, arr[i]});
            }
        }

        return lisLen+1;
    }
}