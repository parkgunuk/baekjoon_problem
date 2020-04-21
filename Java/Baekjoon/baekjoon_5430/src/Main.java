import java.io.*;
import java.util.*;
public class Main {
    private static int stoi(String s){return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = stoi(br.readLine());

        for(int i = 0; i < T; i++) {
            String func = br.readLine();
            int n = stoi(br.readLine());
            String[] nums = br.readLine().replace("[", "").replace("]", "").split(",");
            String[] nums_reverse = new String[n];
            for(int j = 0; j < n; j++) {
                nums_reverse[j] = nums[n - j - 1];
            }

            int mode = 1;
            int cnt_r = 0;
            int cnt = 0;
            String result = "";
            for(int j = 0; j < func.length(); j++) {
                if(func.charAt(j) == 'R') {
                    mode *= -1;
                    continue;
                }
                if(func.charAt(j) == 'D') {
                    if(cnt_r == n || cnt == n) {
                        result = "error";
                        break;
                    }
                    if(mode == -1) {
                        nums_reverse[cnt_r] = "0";
                        nums[n - 1 - cnt_r] = "0";
                        cnt_r ++;

                    }
                    else {
                        nums[cnt] = "0";
                        nums_reverse[n - 1 - cnt] = "0";
                        cnt ++;

                    }
                }
            }

            if(!result.equals("error")) {
                if(mode == 1) {
                    nums = Arrays.copyOfRange(nums, cnt , n - cnt_r);
                    result = Arrays.toString(nums).replace(" ", "");
                }
                else {
                    nums_reverse = Arrays.copyOfRange(nums_reverse, cnt_r, n - cnt);
                    result = Arrays.toString(nums_reverse).replace(" ", "");
                }
            }
            bw.write(result+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}