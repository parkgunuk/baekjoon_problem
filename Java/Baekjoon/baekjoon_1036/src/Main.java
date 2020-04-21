import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    private static final char[] v2c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static class Node implements Comparable<Node>{
        BigInteger val;
        int idx;

        private Node(BigInteger val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return -1 * this.val.compareTo(o.val);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        BigInteger[] val = new BigInteger[37];
        for(int i = 0 ; i < 37 ; ++i) val[i] = BigInteger.ZERO;

        for (int i = 0; i < N; ++i) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < input.length; ++j) {
                val[getValue(input[j])] = val[getValue(input[j])].add(new BigInteger("36").pow(input.length - j - 1));
            }
        }

        int K = Integer.parseInt(br.readLine().trim());

        ArrayList<Node> list = new ArrayList<>();

        for(int i = 0 ; i < 36 ; ++i){
            list.add(new Node(val[i].multiply(new BigInteger(String.valueOf(35-i))), i));
        }

        Collections.sort(list);
        BigInteger res = BigInteger.ZERO;

        for(int i = 0 ; i < K ; ++i) {
            Node n = list.get(i);
            res = res.add(val[n.idx].multiply(new BigInteger("35")));
        }

        for(int i = K ; i < 36 ; ++i){
            Node n = list.get(i);
            res = res.add(val[n.idx].multiply(new BigInteger(String.valueOf(n.idx))));
        }

        System.out.println(DecimalTo36(res));
    }

    private static int getValue(char c) {
        if ('0' <= c && c <= '9') return c - '0';
        else return c - 'A' + 10;
    }

    private static String DecimalTo36(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) return "0";
        StringBuilder sb = new StringBuilder();
        while (n.compareTo(BigInteger.ZERO) > 0) {
            int div = n.remainder(new BigInteger("36")).intValue();
            sb.append(v2c[div]);
            n = n.divide(new BigInteger("36"));
        }
        return sb.reverse().toString();
    }
}