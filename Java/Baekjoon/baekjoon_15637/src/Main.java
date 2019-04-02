import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(1,127);
		map.put(2,110);
		map.put(3,108);
		map.put(4,117);
		map.put(5,114);
		map.put(6,106);
		map.put(7,114);
		map.put(8,118);
		map.put(9,85);
		map.put(10,104);
		map.put(11,112);
		map.put(12,106);
		map.put(13,119);
		map.put(14,116);
		map.put(15,109);
		map.put(16,103);
		map.put(17,119);
		map.put(18,107);
		map.put(19,104);
		map.put(20,126);
		map.put(21,102);
		map.put(22,88);
		map.put(23,98);
		map.put(24,107);
		map.put(25,111);
		map.put(26,115);
		map.put(27,130);
		map.put(28,94);
		map.put(29,95);
		map.put(30,98);
		map.put(31,111);
		map.put(32,96);
		map.put(33,114);
		map.put(34,121);
		map.put(35,106);
		map.put(36,101);
		map.put(37,118);
		map.put(38,107);
		map.put(39,111);
		map.put(40,125);
		map.put(41,91);
		map.put(42,101);
		map.put(43,125);
		map.put(44,107);
		map.put(45,104);
		int N = sc.nextInt();
		System.out.println(map.get(N));
	}

}
