import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet hs = new HashSet();
		ArrayList<String> sb = new ArrayList<String>();
		
		String t = br.readLine();
		int N = Integer.parseInt(t.split(" ")[0]);
		int M = Integer.parseInt(t.split(" ")[1]);
		int cnt = 0;
		
		for(int i = 0; i<N;++i) {
			String st = br.readLine();
			hs.add(st);
		}
		for(int i =0;i<M;++i) {
			String st = br.readLine();
			if(hs.contains(st)) {
				cnt++;
				sb.add(st);
			}
			else {
				hs.add(st);
			}
		}
		Collections.sort(sb);
		System.out.println(cnt);
		for(int i = 0; i<sb.size();++i)
			System.out.println(sb.get(i));
	}
	

}
