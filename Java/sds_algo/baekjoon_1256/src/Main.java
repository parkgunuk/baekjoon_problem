import java.math.BigInteger;
import java.util.*;
public class Main {
    static int N,M;
    static BigInteger K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = new BigInteger(input[2]);
        StringBuilder sb;
        //
        //N+M combi M < K return -1;
        if(combi(N,M).compareTo(K) == -1){
            System.out.println(-1);
        } else {
            sb = new StringBuilder();
            BigInteger combination = BigInteger.ZERO;

            while(combination.compareTo(K) != 0){
                BigInteger combiTemp = combination;
                combination = combination.add(combi(N - 1, M));
                if(combination.compareTo(K) == -1){
                    M--;
                    sb.append("z");
                } else {
                    N--;
                    sb.append("a");
                    combination = combiTemp;
                }
                if(N == 0 || M == 0){
                    break;
                }
            }

            //남은 개수 만큼 추가해주기
            for(int i = 1; i <= M; i++){
                sb.append("z");
            }
            for(int i = 1; i <= N; i++){
                sb.append("a");
            }
            System.out.println(sb.toString());
        }
    }
    private static BigInteger combi (int n, int m){
        BigInteger son = new BigInteger("1");
        BigInteger mother = new BigInteger("1");

        for(int i = 1; i <= n; i++){
            son = son.multiply(new BigInteger(String.valueOf((n+m)-(i-1))));
            mother = mother.multiply(new BigInteger(String.valueOf(i)));
        }

        return son.divide(mother);
    }
}
