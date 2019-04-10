import java.util.*;
public class Main {
	
	static int N,M,d,ans;
	static char[][] map;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	static LinkedList<Node> red;
	static LinkedList<Node> blue;
	static LinkedList<Integer> list;
	static int cb;
	
	static class Node{
		int r,c,cnt;
		LinkedList<Integer> list = new LinkedList<>();
		Node(int r, int c, int cnt, LinkedList<Integer> list){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.list = list;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		String buf = sc.nextLine();
		map = new char[N][];
		visited = new boolean[N][M];
		red = new LinkedList<>();
		blue = new LinkedList<>();
		list = new LinkedList<>();
		
		for(int r = 0;r<N;++r)
			map[r] = sc.nextLine().toCharArray();
		
		for(int r = 0;r<N;++r) {
			for(int c =0;c<M;++c) {
				if(map[r][c] == 'B') blue.add(new Node(r,c,0,list));
				else if(map[r][c] == 'R') red.add(new Node(r,c,0,list));
			}
		}
		moveR();
		moveB();
		
		if(cb<0 && list.size()<= 10 && 0<list.size()) System.out.println(list.size());
		else if(list.size() >11 || list.size() < 1) System.out.println(-1);
		else if(list.size() >= cb) System.out.println(-1);
		
	}
	static void moveR() {
		while(!red.isEmpty()) {
			Node n = red.poll();
			for(int i=0;i<4;++i) {
				LinkedList<Integer> tmp = new LinkedList<>();
				int nr = n.r + dir[i][0];
				int nc = n.c + dir[i][1];
				tmp.addAll(n.list);
				
				if(map[nr][nc] == 'O') {
					tmp.add(i);
					list.addAll(tmp);
					return;
				}
				else if(map[nr][nc] == '.' && !visited[nr][nc]) {
					visited[nr][nc] = true;
					while(true) {
						nr+=dir[i][0];
						nc+=dir[i][1];
						visited[nr][nc] = true;
						
						if(map[nr][nc] == 'O') {
							tmp.add(i);
							map[n.r][n.c] = '.';
							list.addAll(tmp);
							return;
						}
						else if(map[nr][nc] =='#' || map[nr][nc] == 'B') {
							tmp.add(i);
							red.add(new Node(nr-dir[i][0],nc-dir[i][1],n.cnt+1,tmp));
							break;
						}
					}
				}
			}
		}
	}
	static void moveB() {
		int cnt = 0;
		while(!blue.isEmpty()) {
			Node n = blue.poll();
			int nr = n.r;
			int nc = n.c;
			if(list.size() == cnt) {
				cb = -1;
				return;
			}
			int d = list.get(cnt);
			while(true) {
				nr+=dir[d][0];
				nc+=dir[d][1];
				
				if(map[nr][nc] == 'O') {
					cb = cnt;
					return;
				}
				else if(map[nr][nc] =='#' || map[nr][nc] == 'R') {
					blue.add(new Node(nr-dir[d][0],nc-dir[d][1],n.cnt+1,list));
					break;
				}
				
			}
			cnt++;
		}
	}
}
