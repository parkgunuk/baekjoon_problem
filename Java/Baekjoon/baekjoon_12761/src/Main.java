import java.util.*;

public class Main {
	static Queue<Integer> q;
	static int A,B,N,M,ans;
	static final int max = 100000;
	static boolean[] visited = new boolean[max+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		N = sc.nextInt();
		M = sc.nextInt();
		
		q = new LinkedList<Integer>();
		q.add(N);
		
		BFS();
	}
	
	static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			while(size>0) {
				int n = q.poll();
				int next [] = {n+1, n-1, n+A, n+B, n-A, n-B, n*A, n*B, n*(-A), n *(-B)};
				
				if(n == M) {
					System.out.println(ans);
					return;
				}
				
				for(int i = 0;i<10;++i) {
					int na = next[i];	
					
					if(0<=na && na <= max && !visited[na]) {
						visited[na] = true;
						q.add(na);
						
					}
				}
				size--;
			}
			ans++;
		}
	}
}
