import java.util.*;

public class Main {
    static long T;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int N = sc.nextInt();
        int [] A = new int [N+1];
        for(int i=1; i<=N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int [] B = new int [M+1];
        for(int i=1; i<=M; i++) {
            B[i] = sc.nextInt();
        }

        HashMap<Integer,Long> a = new HashMap<Integer,Long>();
        HashMap<Integer,Long> b = new HashMap<Integer,Long>();

        for(int i=1; i<=N; i++) {
            int temp = 0;
            for(int j=i; j<=N; j++) {
                temp+=A[j];
                if(!a.containsKey(temp)) {
                    a.put(temp, (long) 1);
                }else {
                    a.replace(temp, a.get(temp)+1);
                }
            }
        }
        for(int i=1; i<=M; i++) {
            int temp = 0;
            for(int j=i; j<=M; j++) {
                temp+=B[j];
                if(!b.containsKey(temp)) {
                    b.put(temp, (long) 1);
                }else {
                    b.replace(temp, b.get(temp)+1);
                }
            }
        }
        long result = 0;
        Iterator<Integer> it = a.keySet().iterator();
        while(it.hasNext()) {
            int temp = it.next();
            if(b.containsKey(T-temp)) {
                result += a.get(temp)*b.get(T-temp);
            }
        }
        System.out.println(result);
    }
}