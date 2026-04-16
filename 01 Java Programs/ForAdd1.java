// Addition of 10 natural numbers using for loop.
class ForAdd1 {
	public static void main(String arg[]) {
		int add = 0;
		for(int num = 1; num <= 10; add += num, num++);
		System.out.println(add);
	}
}
