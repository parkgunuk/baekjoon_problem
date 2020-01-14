import java.util.*;
public class Main {
    static int N, K, res;
    static int[] arr;
    static boolean[] checked;
    static boolean[] madeNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<K;++i){
            sb.append("99");
        }

        int max = Integer.parseInt(sb.toString())+1;

        madeNum = new boolean[max];

        arr = new int[N];
        checked = new boolean[N];
        for(int i = 0; i<N;++i){
            arr[i] = sc.nextInt();
        }
        res = 0;
        sb = new StringBuilder();
        makeNum(0, sb);
        System.out.println(res);
    }
    private static void makeNum(int cnt, StringBuilder sb){
        if(cnt == K){
            if(madeNum[Integer.parseInt(sb.toString())]) return;
            else{
                madeNum[Integer.parseInt((sb.toString()))] = true;
                res++;
                return;
            }
        }
        for(int i = 0 ; i<N;++i){
            if(checked[i]) continue;
            else{
                checked[i] = true;
                int nowLength = sb.length();
                makeNum(cnt+1, sb.append(arr[i]));
                sb.delete(nowLength, sb.length());
                checked[i] = false;
            }
        }
    }
}