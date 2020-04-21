import java.util.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    static int min = Integer.MAX_VALUE;

    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = stoi(sc.nextLine());
        arr = new int[N+1];
        int j = N-1;
        int x = 0, y = 0;
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i = 0 ; i < N ; ++i) arr[i] = stoi(st.nextToken());

        for(int i = 0 ; i < N ; ++i) {
            while(Math.abs(arr[i] + arr[j]) > Math.abs(arr[i] + arr[j-1]) && i != j-1 && i != j) j--;
            if(i==j) break;
            if(Math.abs(arr[i] + arr[j]) < Math.abs(min)) {
                min = Math.abs(arr[i] + arr[j]);

                x = i;
                y = j;
            }
        }

        System.out.println(arr[x] + " " + arr[y]);
    }
}