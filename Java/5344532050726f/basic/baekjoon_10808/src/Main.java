import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.nextLine().toCharArray();
        int[] arr = new int[26];
        for(int i = 0 ; i<str.length;++i){
            arr[str[i]-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<arr.length-1;++i){
            sb.append(arr[i]+" ");
        }
        sb.append(arr[25]);
        System.out.println(sb);
    }
}
