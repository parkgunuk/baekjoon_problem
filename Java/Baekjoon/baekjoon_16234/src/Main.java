import java.util.*;
import java.io.*;

public class Main {
	private static int stoi(String s){return Integer.parseInt(s);}

	static int N,L,R;
	static int[][] map, dir = {{1,0},{-1,0},{0,1},{0,-1}};;
	static boolean[] visited;
	static ArrayList<Integer> track;
	static int res,total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		map = new int[N][N];
		L = stoi(st.nextToken());
		R = stoi(st.nextToken());

		for(int r = 0;r<N;++r) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0;c<N;++c) {
				map[r][c] = stoi(st.nextToken());
			}
		}
		boolean flag = true;
		res = 0;
		while(flag){
			Queue<Integer> q = new LinkedList<>();
			visited = new boolean[N*N+1];
			flag = false;
			res++;
			for(int i = 0 ; i < N*N ;++i){
				if(visited[i]) continue;
				track = new ArrayList<>();
				int r = i / N;
				int c = i % N;
				q.add(i);
				visited[i] = true;
				track.add(i);
				total = map[r][c];
				int n = 1;

				while(!q.isEmpty()){
					int v = q.poll();
					r = v / N;
					c = v % N;

					for (int k = 0; k < 4; k++) {
						int nx = c + dir[k][0];
						int ny = r + dir[k][1];

						if (0 <= nx && nx < N && 0 <= ny && ny < N) {
							int next = ny * N + nx;
							if (visited[next]) continue;

							int count = map[ny][nx];
							int pivot = map[r][c];
							if (L <= Math.abs(count - pivot) && Math.abs(count - pivot) <= R) {
								// 연합국 조건 성립
								flag = true;
								q.add(next);
								visited[next] = true;
								track.add(next);
								total += map[ny][nx];
								n++;
							}
						}
					}
				}

				int updateN = total / n;
				if (track.size() > 1) {
					for (int v : track) {
						r = v / N;
						c = v % N;
						map[r][c] = updateN;
					}
				}
			}
		}
		System.out.println(res-1);
	}
	
}
