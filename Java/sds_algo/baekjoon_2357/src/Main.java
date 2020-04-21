import java.util.*;
import java.io.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N+1];
        for(int i = 1 ; i<=N;++i){
            arr[i] = stoi(br.readLine());
        }

        int[] min = new int[1<<18];

        init(min, 1, 1, N);

        for(int i = 0 ; i<M;++i){
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());

            int a = search(min, 1, 1, N, s, e);

            sb.append(a+"\n");
        }
        System.out.println(sb.toString());
    }
    private static int init(int[] tmp, int node, int start, int end){
        if(start == end) return tmp[node] = arr[start];

        int mid = (start+end)>>1;
        return tmp[node] = Math.min(init(tmp, node*2, start, mid),
                init(tmp, node*2+1, mid+1, end));
    }

    private static int search(int[] tmp, int node, int start, int end, int left, int right){
        if(left > end || right < start) return Integer.MAX_VALUE;

        if(left <= start && right >= end) return tmp[node];
        else {
            int mid = (start+end)>>1;
            return Math.min(search(tmp,node*2,start,mid,left,right), search(tmp,node*2+1,mid+1,end,left,right));
        }
    }
}
