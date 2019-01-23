import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int count;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		List<Integer> answer = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++){
		      String str = in.readLine();
		      char[] chars = str.toCharArray();
		      for(int j = 0; j < N; j++){
		        map[i][j] = chars[j] - '0';
		     
		      }
		}
		
		for(int row = 0;row<N;++row) {
			for(int col = 0; col<N;++col) {
				if (map[row][col] == 1 && !visited[row][col]) {
					cnt++;
					count = 1;
					DFS(map,visited,N,row,col);
					answer.add(count);
				}
			}
		}
		System.out.println(cnt);
		answer.sort(null);
		for(int i = 0;i<answer.size();++i) {
			System.out.println(answer.get(i));
		}
	}

	
	public static void DFS(int[][] map, boolean[][] visited, int N, int row, int col) {
		visited[row][col] = true;
		
		if( map[row][col] == 0)
			return;
		
		for(int i =0;i<4;++i) {
			int next_r = row + dir[i][0];
			int next_c = col + dir[i][1];
			
			if (0 <= next_r && next_r < N && 0<=next_c&&next_c<N) {
				if(map[next_r][next_c] == 1 && visited[next_r][next_c] == false) {
					count++;
					DFS(map,visited,N,next_r,next_c);
				}
			}
		}
	}

}
