import java.util.*;
// 문제가 이상함...
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
//        HashMap<Integer, Integer> valueMap = new HashMap<>();
//        ArrayList<Integer> root = new ArrayList<>();
//        ArrayList<Integer> keyList = new ArrayList<>();
        ArrayList<int[]> edge = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean flag = false;

        while(true){
            int u = sc.nextInt();
            int v = sc.nextInt();

            if(u == -1 && v == -1) break;
            else if(u==0 && v == 0){
                if(edge.size() + 1 == list.size() || edge.size() == 0)
                    flag = true;
//                boolean flag = true;
//
                sb.append("Case ");
                sb.append(testCase);
//
//                for(int key : keyList){
//                    if(valueMap.get(key) != 1){
//                        flag = false;
//                        break;
//                    }
//                }
//
//                if(root.size() != 1) flag = false;
//                if(root.size() == 0 && valueMap.size() == 0) flag = true;
//
                if (flag) {
                    sb.append(" is a tree.\n");
                } else {
                    sb.append(" is not a tree.\n");
                }
//
                testCase++;
                list.clear();
                edge.clear();
                flag = false;
//                valueMap.clear();
//                root.clear();
//                keyList.clear();
            } else{
//                if(!root.contains(u)) root.add(u);
//
//                if(valueMap.containsKey(v)){
//                    valueMap.replace(v,valueMap.get(v)+1);
//                }
//                else {
//                    valueMap.put(v,1);
//                    if(root.contains(v)) {
//                        for (int i = 0; i < root.size(); ++i) {
//                            if(v == root.get(i)) root.remove(i);
//                        }
//                    }
//                    keyList.add(v);
//                }
                if(!list.contains(u)) list.add(u);
                if(!list.contains(v)) list.add(v);
                int[] tmp = {u,v};
                edge.add(tmp);
            }

        }
        System.out.println(sb.toString());
    }
}
