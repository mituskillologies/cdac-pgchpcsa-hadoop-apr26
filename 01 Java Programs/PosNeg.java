import java.util.Scanner;
class PosNeg {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = in.nextInt();
		if (num > 0) 
			System.out.println(num + " is positive!");
		else
			System.out.println(num + " is negative!");
	}
}
