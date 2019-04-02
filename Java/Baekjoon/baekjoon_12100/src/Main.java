import java.util.*;

public class Main {
	static int N, ans;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
		
		N= sc.nextInt();
		map = new int[N][N];
		
		for(int r = 0; r<N;++r) {
			for(int c = 0; c<N;++c) {
				map[r][c] =sc.nextInt();
			}
		}
		ans = 0;
		int[][] copyMap = new int[N][N];
		for(int i = 0;i<4;++i) {
			for(int j = 0;j<N;++j)
				copyMap[j] = map[j].clone();
			DFS(copyMap, i, 0);
		}
		System.out.println(ans);
	}
	
	static void DFS(int[][] a, int cmd, int cnt) {
		if(cnt == 5) {
			for(int r = 0; r<N;++r) {
				for(int c = 0; c<N;++c) {
					ans = Math.max(ans,a[r][c]);
				}
			}
			return;
		}
		int[][] newMap = new int[N][N];
		
		for(int i = 0; i<N;++i) {
			LinkedList<Integer> vList = new LinkedList<>();
			for(int j = 0 ; j<N;++j) {
				int tmp = cmd<2? a[j][i] : a[i][j];
				if(tmp!=0) vList.add(tmp);
			}
			
			if(cmd == 1 || cmd == 3) Collections.reverse(vList);
			LinkedList<Integer> List = new LinkedList<>();
			for(int j = 0 ; j<vList.size();++j) {
				if(j+1 < vList.size() && vList.get(j).equals(vList.get(j+1))) {
					List.add(vList.get(j)*2);
					j++;
				}
				else List.add(vList.get(j));
			}
			for(int j = List.size(); j<N;++j) List.add(0);
			if(cmd==1 || cmd==3) Collections.reverse(List);
			
			for(int j = 0; j<N;++j) {
				if(cmd <2) newMap[j][i] = List.pollFirst();
				else newMap[i][j] = List.pollFirst();
			}
			
		}
		
		for(int i = 0; i<4;++i) {
			DFS(newMap, i, cnt+1);
		}
		
	}
	
}
