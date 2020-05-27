import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        String hexStr[] = br.readLine().split(" ");

        for(String hex : hexStr) {
            int dec = Integer.parseInt(hex, 16);
            sb.append(64 <= dec && dec <= 95 ? "-" : ".");
        }

        System.out.println(sb.toString());
    }
}