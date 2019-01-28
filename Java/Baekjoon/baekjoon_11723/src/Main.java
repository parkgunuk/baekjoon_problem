import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] string = new String[2];
		
		int M = Integer.parseInt(br.readLine());
		int bit = 0;
		
		for(int i=0;i<M;++i) {
			string = br.readLine().split(" ");
			
			switch (string[0]) {
				case "add":
					bit = bit|(1<<Integer.parseInt(string[1]));
					break;
				case "remove":
					bit = bit&~(1<<Integer.parseInt(string[1]));
					break;
				case "check":
					
					if ((bit&(1<<Integer.parseInt(string[1])))>0) {
						bw.write("1"+"\n");
					}
					else {
						bw.write("0"+"\n");
					}
					break;
					
				case "toggle":
					bit = bit^(1<<Integer.parseInt(string[1]));
					break;
					
				case "all":
					bit = (1<<21)-1;
					break;
					
				case "empty":
					bit =0;
					break;

			}
		}
		bw.flush();
		bw.close();
	}

}
