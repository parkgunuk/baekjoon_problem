import java.util.*;
public class Main {
    static boolean[] isNotPrime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        String P = s[0];
        int K = Integer.parseInt(s[1]);

        init(K+1);
        for(int i = 2;i<K;++i){
            if(!isNotPrime[i] && mod(P,i) == 0){
                System.out.println("BAD "+i);
                return;
            }
        }
        System.out.println("GOOD");
    }
    private static void init(int size){
        isNotPrime = new boolean[size+1];
        int i,j;
        for(i = 2; i*i<size;++i){
            if(!isNotPrime[i])
                for(j=i*i;j<size;j+=i)
                    isNotPrime[j] = true;
            isNotPrime[1] = true;
        }
    }
    private static int mod(String s, int div){
        int res = 0;
        char[] t = s.toCharArray();
        for (int i=0; i<t.length ;++i) res = (res*10 + (t[i]-'0')) % div;
        return res;
    }
}
