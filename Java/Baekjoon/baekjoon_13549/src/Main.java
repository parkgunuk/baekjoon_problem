import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,K;
	static int[] dir = {-1,0,1};
	static int ans = 0;
	static Queue<Node> q;
	static final int max=100000;
	static boolean[][] visited = new boolean[max+1][3];
	static class Node{
		int x;
		int time;
		
		Node(int x, int time){
			this.x = x;
			this.time = time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		q = new LinkedList<Node>();
		
		q.add(new Node(N,0));
		go();
		System.out.println(ans);
	}
	static void go(){
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			int num = tmp.x;
			int time = tmp.time;
			
			if(K == num) {
				ans = time;
				return;
			}
			for(int i=0;i<3;++i) {
				int nn = num+dir[i];
				if(i==1) {
					nn = num*2;
				}
				if(0<=nn && nn <=max && !visited[nn][i]) {
					visited[nn][i] = true;
					if(i==1)
						q.add(new Node(nn,time));
					else
						q.add(new Node(nn,time+1));
				
				}
			}
		}
		
	}
}