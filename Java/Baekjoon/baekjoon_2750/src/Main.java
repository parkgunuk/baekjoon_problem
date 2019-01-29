import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for(int i = 0 ; i<N;++i)
			ans.add(Integer.parseInt(br.readLine()));
	
		Collections.sort(ans);
		
		for(int i = 0 ;i<N;++i)
			System.out.println(ans.get(i));
	}

}
