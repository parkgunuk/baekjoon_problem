import java.util.*;

public class Main {
    static List<String> cmdStack;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while(true){
            cmdStack =  new ArrayList<String>();

            while(true){
                String s = sc.nextLine();
                if(s.equals("END")) break;
                if(s.equals("QUIT")){
                    System.out.println(sb.toString());
                    return;
                }
                cmdStack.add(s);
            }
            cmdStack.add("END");

            int N = sc.nextInt();
            List<Long>[] inputs = new List[N];
            boolean[] isError = new boolean[N];
            for(int i = 0 ;i<N;++i){
                inputs[i] = new ArrayList<Long>();
                inputs[i].add((long) sc.nextInt());
            }

            sc.nextLine();

            for(int i = 0 ; i<cmdStack.size();++i){
                String[] s = cmdStack.get(i).split(" ");
                switch (s[0]){
                    case "NUM":
                        for(int j = 0;j<N;++j) {
                            inputs[j].add(Long.parseLong(s[1]));
                        }
                        break;

                    case "POP":
                        for (int j = 0; j < N; ++j) {
                            int size = inputs[j].size();
                            if(size != 0) inputs[j].remove(size-1);
                            else isError[j] = true;
                        }
                        break;

                    case "INV":
                        for (int j = 0; j < N; ++j) {
                            int size = inputs[j].size();
                            if(size != 0) {
                                Long temp = inputs[j].get(size-1);
                                inputs[j].remove(size-1);
                                inputs[j].add(temp * -1);
                            } else isError[j] = true;
                        }
                        break;

                    case "DUP":
                        for(int j = 0 ;j<N ;++j){
                            int size = inputs[j].size();
                            if(size != 0) {
                                Long tmp = inputs[j].get(size-1);
                                inputs[j].add(tmp);
                            } else isError[j] = true;
                        }
                        break;

                    case "SWP":
                        for (int j = 0; j < N; j++) {
                            int size = inputs[j].size();
                            if (size >= 2) {
                                Long tempA = inputs[j].get(size - 1);
                                inputs[j].remove(size - 1);
                                Long tempB = inputs[j].get(size - 2);
                                inputs[j].remove(size - 2);
                                inputs[j].add(tempA);
                                inputs[j].add(tempB);
                            } else isError[j] = true;
                        }
                        break;

                    case "ADD":
                        for(int j = 0; j<N;++j){
                            int size = inputs[j].size();
                            if(size>=2){
                                Long tempA = inputs[j].get(size-1);
                                inputs[j].remove(size-1);
                                Long tempB = inputs[j].get(size-2);
                                inputs[j].remove(size-2);
                                inputs[j].add(tempB+tempA);
                            } else isError[j] = true;


                        }
                        break;

                    case "SUB":
                        for(int j = 0 ;j<N;++j){
                            int size = inputs[j].size();
                            if (size >= 2) {
                                Long tempA = inputs[j].get(size-1);
                                inputs[j].remove(size-1);
                                Long tempB = inputs[j].get(size-2);
                                inputs[j].remove(size-2);
                                inputs[j].add(tempB-tempA);
                            } else isError[j] = true;
                        }
                        break;

                    case "MUL":
                        for(int j = 0 ;j<N;++j){
                            int size = inputs[j].size();
                            if (size >= 2) {
                                Long tempA = inputs[j].get(size-1);
                                inputs[j].remove(size-1);
                                Long tempB = inputs[j].get(size-2);
                                inputs[j].remove(size-2);
                                inputs[j].add(tempB * tempA);
                            } else isError[j] = true;
                        }
                        break;

                    case "DIV":
                        for(int j = 0 ;j<N;++j){
                            int size = inputs[j].size();
                            if (size >= 2) {
                                Long tempA = inputs[j].get(size-1);
                                inputs[j].remove(size-1);
                                Long tempB = inputs[j].get(size-2);
                                inputs[j].remove(size-2);
                                if (tempA != 0) inputs[j].add(tempB/tempA);
                                else isError[j] = true;
                            } else isError[j] = true;
                        }
                        break;

                    case "MOD":
                        for(int j = 0 ;j<N;++j){
                            int size = inputs[j].size();
                            if (size >= 2) {
                                Long tempA = inputs[j].get(size-1);
                                inputs[j].remove(size-1);
                                Long tempB = inputs[j].get(size-2);
                                inputs[j].remove(size-2);
                                if (tempA != 0) inputs[j].add(tempB%tempA);
                                else isError[j] = true;
                            } else isError[j] = true;
                        }
                        break;

                    case "END":
                        String[] temp = new String[N];
                        for (int j = 0; j < N; j++) {
                            if(isError[j]) temp[j] = "ERROR";
                            else if(inputs[j].size() != 1) temp[j] = "ERROR";
                            else if(Math.abs(inputs[j].get(0)) > 1e9) temp[j] = "ERROR";
                            else temp[j] = String.valueOf(inputs[j].get(0));
                        }

                        for (int j = 0; j < temp.length; j++) {
                            sb.append(temp[j]).append("\n");
                        }
                        break;
                }
            }
            sb.append("\n");

        }
    }

}
