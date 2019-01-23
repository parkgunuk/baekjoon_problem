import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int cnt = 0;
	static StringBuilder string = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(in.readLine());
		
		
		hanoi(K, "1","2","3");
		System.out.println(cnt);
		System.out.println(string.toString());
	}
	
	public static void hanoi(int K, String start, String tmp, String target) {

		if(K<2) {
			string.append(start+" "+target+"\n");
			cnt++;
			return;
		}
		
		hanoi(K-1,start,target,tmp);
		hanoi(1,start,tmp,target);
		hanoi(K-1, tmp, start, target);
		

	}
	
}