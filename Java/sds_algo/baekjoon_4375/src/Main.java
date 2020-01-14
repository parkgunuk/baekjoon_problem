import java.util.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while (sc.hasNext() && !(s = sc.nextLine()).equals("")) {
            BigInteger t = new BigInteger(s);
            BigInteger temp = BigInteger.ONE;

            while (true) {
                if (temp.mod(t).compareTo(BigInteger.ZERO) == 0) {
                    System.out.println(temp.toString().length());
                    break;

                } else {
                    temp = temp.multiply(BigInteger.TEN);
                    temp = temp.add(BigInteger.ONE);

                }
            }
        }
    }
}
