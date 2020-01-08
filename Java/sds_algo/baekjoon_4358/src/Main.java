import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str;

        HashMap<String, Integer> dic = new HashMap<>();
        ArrayList<String> keyList = new ArrayList<>();
        int cnt = 0;

        while (sc.hasNextLine() && !(str = sc.nextLine()).equals("")) {
            cnt++;
            if(dic.containsKey(str)) dic.replace(str, dic.get(str)+1);
            else {
                dic.put(str,1);
                keyList.add(str);
            }
        }
        Collections.sort(keyList);
        for(String key : keyList){
            sb.append(key+" ");
            sb.append(String.format("%,.4f",(double)(dic.get(key)*100)/cnt));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
