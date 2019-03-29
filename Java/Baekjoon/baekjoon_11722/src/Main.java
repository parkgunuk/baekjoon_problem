import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] ans = new int[N];
		for(int i=0;i<N;++i) {
			arr[i] = sc.nextInt();
		}
		Arrays.fill(ans, 1);
		for(int i=0;i<N;++i) {
			for(int j = i ; j>=0;--j) {
				if(arr[j] > arr[i] && ans[j] >= ans[i]) {
					ans[i] = ans[j]+1;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		
		for(int i =0;i<N;++i) {
			max = max>ans[i]?max:ans[i];
		}
		System.out.println(max);
	}

}