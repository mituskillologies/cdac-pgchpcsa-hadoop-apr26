
class ArraysAdd {
	public static void main(String arg[]) {
		int num[] = {61,59,32,45,92};
		int add = 0;
		
		for(int n : num)                // for each loop
			add += n;
		
		System.out.println("Average:" + add / num.length);	
	}
}
