import java.util.*;
import java.io.*;
// 중복된 값이 있는 경우 이기 떄문에 hashmap을 사용
/*
2
0 -100 2 2
0 -4 2 4
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> cdMap = new HashMap<Integer,Integer>();

        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        int[] AB = new int[N*N];
        Arrays.fill(AB,Integer.MIN_VALUE);
        long result = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[i*N+j] = A[i] + B[j];
                int temp = C[i] + D[j];
                if(cdMap.containsKey(temp)) cdMap.replace(temp,cdMap.get(temp)+1);
                else cdMap.put(temp, 1);
            }
        }

        for (int i = 0; i < N*N; i++) {
            if(AB[i] == Integer.MIN_VALUE) break;

            int searchKey = -AB[i];
            if(cdMap.containsKey(searchKey)) {
                result += cdMap.get(searchKey);
            }
        }
        System.out.println(result);
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        long[][] arr = new long[4][n];
//        for(int j = 0 ;j<n;++j) {
//            for (int i = 0; i < 4; ++i) {
//                arr[i][j] = sc.nextLong();
//            }
//        }
//        for(int i = 0 ;i<4;++i){
//            Arrays.sort(arr[i]);
//        }
//
//        long[] listCD = new long[n*n];
//
//        int cnt = 0;
//        for(int i = 0; i<n;++i){
//            for(int j = 0 ;j<n;++j){
//                listCD[cnt++] = arr[2][i] + arr[3][j];
//            }
//        }
//        Arrays.sort(listCD);
//
//        long ans = 0;
//        for(int i = 0 ; i<n;++i){
//            for(int j = 0 ; j<n;++j){
//                long a = arr[0][i]+arr[1][j];
////                int left = 0;
////                int right = n*n;
////                while(left<right){
////                    int mid = (left+right)/2;
////                    if(a+listCD[mid]>0) right = mid-1;
////                    else if(a+listCD[mid]<0) left = mid +1;
////
////                    if(a+listCD[mid] == 0) {
////                        ans++;
//////                        break;
////                    }
////                }
//                System.out.println(Arrays.binarySearch(listCD,-a));
//            }
//        }
//        System.out.println(ans);
    }

}
