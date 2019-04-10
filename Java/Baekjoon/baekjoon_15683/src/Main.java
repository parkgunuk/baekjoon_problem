import java.util.*;

public class Main {
	static int N,M;
	static int[][] map;
	static int[] view;
	static int ans = Integer.MAX_VALUE;
	static List<Node> list;
	static Queue<Node> q;
	static int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
	
	static class Node{
		int r;
		int c;
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		list = new ArrayList<>();
		q = new LinkedList<>();
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<M;++c) {
				map[r][c] = sc.nextInt();
				if(1<=map[r][c] && map[r][c] <5) list.add(new Node(r,c));
				else if(map[r][c] == 5) q.add(new Node(r,c));
			}
		}
		view = new int[list.size()];
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			saw(map,1,n.r,n.c);
			saw(map,2,n.r,n.c);
			saw(map,3,n.r,n.c);
			saw(map,4,n.r,n.c);
		}
		
		go(0,list.size());
		System.out.println(ans);
	}
	static void go(int lev, int max_lev) {
		if(lev == max_lev) {
			int[][] tmp = new int[N][];
			for(int i = 0;i<N;++i)
				tmp[i] = map[i].clone();
			
			for(int i = 0;i<max_lev;++i) {
				Node n = list.get(i);
				if(tmp[n.r][n.c] == 1) {
					saw(tmp,view[i],n.r,n.c);
				}
				else if(tmp[n.r][n.c] == 2) {
					saw(tmp,view[i],n.r,n.c);
					saw(tmp,(view[i]+1)%4+1,n.r,n.c);
				}
				else if(tmp[n.r][n.c] == 3 ) {
					saw(tmp,view[i],n.r,n.c);
					saw(tmp,view[i]%4+1,n.r,n.c);
				}
				else if(tmp[n.r][n.c] == 4) {
					saw(tmp,view[i],n.r,n.c);
					saw(tmp,view[i]%4+1,n.r,n.c);
					saw(tmp,(view[i]+2)%4+1,n.r,n.c);
				}
			}
			int res = count(tmp);
//			System.out.println(Arrays.toString(view));
//			System.out.println(res);
			ans = Math.min(ans, res);
			return;
		}
		for(int i = 1;i<5;++i) {
			view[lev] = i;
			go(lev+1,max_lev);
		}
	}
	static void saw(int[][] copyMap, int d, int r, int c) {
		int nr = r;
		int nc = c;
		while(true) {
			nr += dir[d-1][0];
			nc += dir[d-1][1];
			
			if(nr<0 || nr>=N || nc<0 || nc>=M || copyMap[nr][nc] == 6) break;
			if(copyMap[nr][nc] == 0) copyMap[nr][nc] = map[r][c];
		}
	}
	static int count(int[][] a) {
		int cnt = 0;
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<M;++c) {
				if(a[r][c] == 0) cnt++; 
			}
		}
		return cnt;
	}
}
