import java.util.*;
public class Main {
    static final int SIZE = 1000008;
    static boolean[] isNotPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        init();
        int N;
        while((N=sc.nextInt()) != 0){
            boolean flag = false;
            for(int i = 2; i <= N/2; i++) {
                if(!isNotPrime[i] && !isNotPrime[N-i]) {
                    sb.append(N+" = "+i+" + "+(N-i)+"\n");
                    flag = true;
                    break;
                }
            }
            if(!flag)
                sb.append("Goldbach's conjecture is wrong.");
        }
        System.out.println(sb.toString());
    }
    private static void init(){
        isNotPrime = new boolean[SIZE];

        int i, j;
        for(i=2;i*i<SIZE;i++)
            if(!isNotPrime[i])
                for(j=i*i;j<SIZE;j+=i)
                    isNotPrime[j] = true;
        isNotPrime[1] = true;
    }
}
