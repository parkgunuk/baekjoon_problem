import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());
        int[] arr = new int[M];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i = 0 ; i<M;++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }
        int K =Integer.parseInt(sc.nextLine());

        BigDecimal mother = BigDecimal.ONE;
        BigDecimal son = BigDecimal.ZERO;

        for(int i = 0 ; i<K;++i){
            mother = mother.multiply(new BigDecimal(String.valueOf((sum-i)*1.0)));
        }
        for(int i = 0 ; i<M;++i){
            BigDecimal tmp = BigDecimal.ONE;
            if(arr[i]<K) continue;

            for(int j = 0 ;j<K;++j){
                tmp = tmp.multiply(new BigDecimal(String.valueOf((arr[i]-j)*1.0)));
            }
            son = son.add(tmp);
        }
        mother.doubleValue();
        son.doubleValue();

        System.out.println(son.divide(mother, 9, RoundingMode.HALF_EVEN));
    }
}
