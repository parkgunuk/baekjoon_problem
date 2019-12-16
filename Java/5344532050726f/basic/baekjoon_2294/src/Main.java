import java.util.*;
public class Main {
    static int[] coin;
    static int N,K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        coin = new int[N];
        boolean[] isCoin = new boolean[100001];
        int idx = 0;

        for(int i=0;i<N;++i){
            int c = sc.nextInt();
            if(isCoin[c]) {
                continue;
            }
            else{
                isCoin[c] = true;
                coin[idx++] = c;
            }
        }

    }
}
