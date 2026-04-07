import java.util.Scanner;
class Read {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = in.nextInt();
		System.out.print("Enter second number: ");
		int num2 = in.nextInt();
		int add = num1 + num2;
		System.out.println("Addition is: " + add);
	}
}
