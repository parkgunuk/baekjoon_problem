import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ;i<N;++i){
            String[] val = br.readLine().split(" ");

            sb.append(Integer.parseInt(val[0])+Integer.parseInt(val[1]));
            sb.append("\n");
        }
        bw.write(sb.toString());

        bw.close();
        br.close();

    }
}
