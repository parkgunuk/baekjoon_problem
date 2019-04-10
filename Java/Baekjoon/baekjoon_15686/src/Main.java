import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static LinkedList<Node> list;
	static LinkedList<Node> HomeList;
	static class Node{
		int r;
		int c;
		int d;
		Node(int r, int c, int d){
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static int ans = Integer.MAX_VALUE;
	static int[] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		list = new LinkedList<>();
		HomeList = new LinkedList<>();
		check = new int[M];
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<N;++c) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 2) list.add(new Node(r,c,0));
				else if(map[r][c] == 1) HomeList.add(new Node(r,c,Integer.MAX_VALUE));
			}
		}
		go(0,-1);
		System.out.println(ans);
	}
	static void go(int depth, int b) {
		if(depth == M) {
			int sum = 0;
			for(Node n : HomeList) n.d = Integer.MAX_VALUE;
			
			for(int i = 0 ; i<M;++i) {
				Node store = list.get(check[i]);
				for(int j = 0;j<HomeList.size();++j) {
					Node home = HomeList.get(j);
					
					home.d = Math.min(home.d, cal(store.r,store.c,home.r,home.c));
				}
			}
			
			for(Node n : HomeList) sum += n.d;
			
			ans = Math.min(ans, sum);
			return;
		}
		for(int i = 0;i<list.size();++i) {
			if(i<=b) continue;
			check[depth] = i;
			go(depth+1,i);
		}
	}
	
	static int cal(int r, int c, int rr, int cc) {
		return Math.abs(r-rr) + Math.abs(c-cc);
	}
}
