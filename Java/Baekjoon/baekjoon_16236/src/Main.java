import java.util.*;
import java.io.*;

public class Main {
	private static int stoi(String s){return Integer.parseInt(s);}

	private static class Node implements Comparable<Node>{
		int r, c, size;

		private Node (int r, int c, int size){
			this.r = r;
			this.c = c;
			this.size = size;
		}

		@Override
		public int compareTo(Node o) {
			if(this.r == o.r){
				return this.c - o.c;
			}
			return this.r - o.r;
		}
	}

	private static int N, sharkSize = 2, fishCnt;

	private static int[][] map;
	private static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = stoi(br.readLine());
		map = new int[N][N];
		fishCnt = 0;
		Queue<Node> q = new LinkedList<>();

		for(int i = 0 ; i < N ; ++i){
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; ++j){
				map[i][j] = stoi(st.nextToken());
				if(map[i][j] == 9) {
					q.add(new Node(i,j,2));
					map[i][j] = 0;
				}
				else if( map[i][j] != 0 ) fishCnt++;
			}
		}

		int time = 0;
		boolean flag = false;

		while(!q.isEmpty() || fishCnt != 0)	{
			Node n = q.poll();

			int rr = n.r;
			int cc = n.c;

			int[][] dist = calDist(rr, cc, n.size);
			ArrayList<Node>[] fish = new ArrayList[N * N];

			for (int i = 0; i < N*N; ++i) fish[i] = new ArrayList<>();

			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					if (dist[i][j] == Integer.MAX_VALUE) continue;

					if (map[i][j] < sharkSize && map[i][j] != 0 && map[i][j] != 9) {
						// idx 거리에 먹을수있는 고기가가 있음
						fish[dist[i][j]].add(new Node(i, j, map[i][j]));
					}
				}
			}

			flag = false;

			for (ArrayList<Node> list : fish) Collections.sort(list);

			int i;
			for (i = 0; i < fish.length; ++i) {
				if (fish[i].size() != 0) {
					time += dist[fish[i].get(0).r][fish[i].get(0).c];

					fishCnt--;
					map[fish[i].get(0).r][fish[i].get(0).c] = 0;

					if(n.size-1 == 0) {
						q.add(new Node(fish[i].get(0).r, fish[i].get(0).c, ++sharkSize));
						flag=true;
					} else {
						q.add(new Node(fish[i].get(0).r, fish[i].get(0).c, n.size -1));
						flag=true;
					}

					break;
				}
			}
			if(!flag)break;

		}

		System.out.println(time);
	}
	private static boolean isPossible(int r, int c){
		if(r < 0 || r >= N || c < 0 || c >= N) return false;
		return true;
	}

	private static int[][] calDist(int r, int c, int size) {
		Queue<Node> q = new LinkedList<>();
		int dist[][] = new int[N][N];

		q.add(new Node(r, c, size));

		for (int i = 0; i < N; ++i) Arrays.fill(dist[i], Integer.MAX_VALUE);

		dist[r][c] = 0;

		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < 4; ++i) {
				int nx = n.r + dir[i][0];
				int ny = n.c + dir[i][1];

				if (isPossible(nx, ny) && dist[nx][ny] > dist[n.r][n.c] + 1) {
					if (map[nx][ny] == 0) {
						dist[nx][ny] = dist[n.r][n.c] + 1;
						q.add(new Node(nx, ny, n.size));
					} else if (map[nx][ny] != 9 && map[nx][ny] <= sharkSize) {
						dist[nx][ny] = dist[n.r][n.c] + 1;
						q.add(new Node(nx, ny, n.size));
					}
				}
			}
		}

		return dist;
	}

}
