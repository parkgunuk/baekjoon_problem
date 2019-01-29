import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" ");
		int[] people = new int[line.length];
		for(int i = 0; i < 4; i++) {
			people[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(people);
		bw.write((int)Math.abs(people[3] + people[0] - people[1] - people[2]) + "\n");
		bw.flush();
		
	}

}
