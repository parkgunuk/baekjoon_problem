import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");
		int A = Integer.parseInt(st[0]);
		int B = Integer.parseInt(st[1]);
		int C = Integer.parseInt(br.readLine());
		
		int total = (A*60+B+C);
		int hour = (total/60)%60;
		int min = total%60;
		
		System.out.println(hour+" "+min);
	}

}
