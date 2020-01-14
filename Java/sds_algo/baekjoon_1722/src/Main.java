import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int check = sc.nextInt();
        long[] facto = new long[num+1];
        boolean[] c = new boolean[num+1];

        facto[0] = 1;
        for(int i=1; i<=num; i++) {
            facto[i] = facto[i-1]*i;
        }

        if(check == 1) {//num까지 순열중 where번째 순열은?
            long where = sc.nextLong();
            int[] arr = new int[num];
            for(int i=0 ; i<num ; i++) {
                for(int j=1; j<=num; j++) {
                    if(c[j] == true) continue;
                    if(facto[num-i-1] < where) {
                        where -= facto[num-i-1];
                    }else {
                        arr[i] = j;
                        c[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<num; i++) {
                System.out.print(arr[i]+" ");
            }

        }else {//주어진순열이 몇번째순열?
            int[] arr = new int[num];
            for(int i=0; i<num; i++) {
                arr[i] = sc.nextInt();
            }

            long result = 0;
            for(int i=0; i<num; i++) {
                for(int j=1; j<arr[i]; j++) {
                    if(c[j] == false) {
                        result += facto[num-i-1];
                    }
                }
                c[arr[i]] = true;
            }
            System.out.println(result+1);
        }
    }
}
