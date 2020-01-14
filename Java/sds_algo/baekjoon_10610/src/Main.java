import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s = sc.nextLine().toCharArray();
        int[] arr = new int[s.length];

        int sum = 0;
        int cnt = 0;
        boolean flag = false;

        for(int i = 0 ; i<s.length;++i){
            arr[i] = (s[i]-'0')*(-1);
            if(s[i] == '0') cnt++;
            sum+=(arr[i]*-1);
        }

        if(cnt>0 && sum%3 == 0){
            flag = true;
            Arrays.sort(arr);
        }
        StringBuilder sb = new StringBuilder();
        if(flag) {
            for (int i = 0; i < arr.length; ++i) {
                sb.append((arr[i]*-1));
            }
        } else {
            sb.append(-1);
        }

        System.out.println(sb.toString());
    }
}
