import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static Queue<Node> q;
	static class Node{
		int r;
		int c;
		int s;
		int t;
		Node (int r, int c, int s, int t){
			this.r = r;
			this.c = c;
			this.s = s;
			this.t = t;
		}
	}
	static int[][] dir = {{},{},{},{}}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		map = new int[N][N];
		q = new LinkedList<>();
		
		for(int r=0;r<N;++r) {
			for(int c =0;c<N;++c) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 9) q.add(new Node(r,c,2,0));
			}
		}
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
		}
		
		
	}

}
