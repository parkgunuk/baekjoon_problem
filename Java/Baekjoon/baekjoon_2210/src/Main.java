import java.util.*;

public class Main {
	
	static int[][] map = new int[5][5];
	static Set<String> set;
	static Queue<String[]> q;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		set = new HashSet<String>();
		q = new LinkedList<String[]>();
		
		for(int r = 0;r<5;++r) {
			for(int c = 0;c<5;++c) {
				map[r][c] = sc.nextInt();
			}
		}
		for(int r = 0; r<5;++r) {
			for(int c = 0; c<5;++c) {
				String[] tmp = {String.valueOf(r),String.valueOf(c),""};
				q.add(tmp);
				BFS();
			}
		}
		System.out.println(set.size());
	}
	static void BFS() {
		while(!q.isEmpty()) {
			String[] tmp = q.poll();
			int r = Integer.parseInt(tmp[0]);
			int c = Integer.parseInt(tmp[1]);
			String str = tmp[2];
			
			if(str.length() == 6) {
				set.add(str);
				continue;
			}
			
			for(int i = 0;i<4;++i) {
				int nr = r+dir[i][0];
				int nc = c+dir[i][1];
				
				if(0<=nr && nr<5&&0<=nc && nc<5) {
					String[] tmp1 = {String.valueOf(nr), String.valueOf(nc), str+""+map[r][c]};
					q.add(tmp1);
				}
			}
		}
		
	}

}
