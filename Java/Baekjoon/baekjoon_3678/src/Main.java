import java.util.*;

public class Main {
	static int N;
	static int[] value;
	static LinkedList<Node> list;
	static class Node{
		Node root;
		List<Node> nodeList;
		int value;
		
		public Node(Node root, List<Node> nodeList, int value) {
			this.root = root;
			this.nodeList = nodeList;
			this.value = value;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		for(int t = 0; t<tc;++t) {
			value = new int[6];
			Arrays.fill(value, 0);
			list = new LinkedList<>();
			N = sc.nextInt();
			int i = 0;
			int ans = 1;
			while(i!=N) {
				if(i == 0) {
					value[1]++;
					List<Node> tmp = new ArrayList<>();
					list.add(new Node(null,tmp,1));
					
				}
				else if(i==1) {
					value[2]++;
					
					
					Node temp = list.getLast();
					List<Node> tmp = new ArrayList<>();
					tmp.add(temp);
					Node temp1 = new Node(list.getFirst(),tmp,2);
					
					temp.nodeList.add(temp1);
					list.add(temp1);
					ans = 2;
				}
				else {
					int size = list.size();
					List<Node> tmpList = new ArrayList<>();
					Node last = list.getLast();
					Node root = last.root;
					
					if(root.nodeList.size() == 6) {
						list.removeFirst();
						root = list.getFirst();
					}
					int val = getVal(last.value, root.value);
					value[val]++;
					tmpList.add(root);
					tmpList.add(last);
					if(root.nodeList.size()==5) {
						tmpList.add(list.get(1));
					}
					Node temp = new Node(root,tmpList,val);
					root.nodeList.add(temp);
					list.add(temp);
					
					System.out.println("nowValue"+val);
					ans = val;
				}
				
				i++;
			}
			
			System.out.println(ans);
		}
	}
	static int getVal(int a, int b) {
		int ans = 0;
		int min = Integer.MAX_VALUE;

		for(int i = 1;i<=5;++i) {
			if(i == a || i == b) continue;
			if(value[i] < min) {
				min = value[i];
				ans = i;
			}
		}
		return ans;
	}
}
