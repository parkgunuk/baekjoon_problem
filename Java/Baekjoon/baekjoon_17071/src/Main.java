import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,K;
	static int[] dir = {-1,0,1};
	static int ans = 0;
	static Queue<Node> q;
	static final int max=500000;
	static boolean[][] visited = new boolean[max+1][3];
	static int[] dp;
	static class Node{
		int x;
		int time;
		int k;
		
		Node(int x, int time, int k){
			this.x = x;
			this.time = time;
			this.k = k;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		q = new LinkedList<Node>();
		q.add(new Node(N,0,K));
		go();
		System.out.println(ans);
	}
	static void go(){
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			int num = tmp.x;
			int time = tmp.time;
			int k = tmp.k;
			
			if(k == num) {
				ans = time;
				return;
			}
			if(k > max || num >max) {
				ans = -1;
				return;
			}
			for(int i=0;i<3;++i) {
				int nn = num+dir[i];
				if(i==1) {
					nn = num*2;
				}
				if(0<=nn && nn <=max && !visited[nn][i]) {
					visited[nn][i] = true;
					q.add(new Node(nn,time+1,k+time+1));
				}
			}
		}
	}
}