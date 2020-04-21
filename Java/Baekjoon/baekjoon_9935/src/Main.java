import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();

        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < bomb.length() ; ++i) set.add(bomb.charAt(i));

        for(int i = 0 ; i < input.length() ; ++i){
            sb.append(input.charAt(i));
            int j = bomb.length();

            if(input.charAt(i) == bomb.charAt(--j)){
                if(sb.length() - bomb.length() < 0) continue;

                boolean flag = false;
                int size = sb.length() - bomb.length();

                for(int k = sb.length()-1; k >= size; k--) {
                    if(sb.charAt(k) == bomb.charAt(j--)) flag = true;
                    else {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int k = 0 ; k < bomb.length() ; ++k){
                        if(sb.length()!=0) sb.deleteCharAt(sb.length()-1);
                    }
                }
            }
        }
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb.toString());
    }
}