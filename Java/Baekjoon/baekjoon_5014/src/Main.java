import java.util.*;

public class Main {
	static int F,S,G,U,D;
	static Queue<Node> q;
	static int[] d = new int[2];
	static boolean[] visited;
	static class Node{
		int x;
		int c;
		Node(int x, int c){
			this.x = x;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		d[0] = U;
		d[1] = -D;
		
		q = new LinkedList<>();
		int ans = 0;
		q.add(new Node(S,0));
		visited = new boolean[F+1];
		visited[S] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.x == G) {
				ans = n.c+1;
				break;
			}
			for(int i =0;i<2;++i){
				int nx = n.x+d[i];
				
				if(0<nx && nx <=F && !visited[nx]) {
					visited[nx] = true;
					q.add(new Node(nx,n.c+1));
				}
			}
		}
		if(ans == 0)System.out.println("use the stairs");
		else System.out.println(ans-1);

		
	}

}
