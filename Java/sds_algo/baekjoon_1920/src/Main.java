import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N];
        for(int i = 0 ; i<N;++i){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int M = sc.nextInt();
        for(int i = 0; i<M;++i){
            System.out.println(isExist(sc.nextInt()));
        }

    }
    private static int isExist(int n){
        int left = 0;
        int right = arr.length-1;

        while(left<=right){
            int mid = (left+right)/2;

            if(n>arr[mid]) left = mid+1;
            else if (n < arr[mid]) right = mid-1;
            else return 1;
        }

        return 0;
    }
}

