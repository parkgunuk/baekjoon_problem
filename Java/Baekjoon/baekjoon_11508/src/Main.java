import java.util.*;
public class Main {
	
	static int N,ans;
	static int[] goods;
	static int max = Integer.MIN_VALUE;
	static int[][] combine;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ans = 0;
		goods = new int[N];
		combine = new int[N/3 +1][];
		for(int i = 0;i<N;++i) {
			goods[i] = sc.nextInt();
			ans+=goods[i];
		}
		Arrays.sort(goods);
		int lim = N/3;
		for(int i = 1; i<=lim;++i) {
			ans-=goods[N-(3*i)];
		}
		
		System.out.println(ans);
	}
	
}
