import java.util.*;
import java.io.*;

public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = stoi(br.readLine());
        int [] arr = new int [10001];

        while(N-->0)arr[stoi(br.readLine())]++;

        for( int i = 0; i < arr.length; i++ )
            if( arr[i] > 0 )
                for( int j = 0; j < arr[i]; j++ ) {
                    bw.write(i + "\n");
                }
        bw.flush();
    }
}