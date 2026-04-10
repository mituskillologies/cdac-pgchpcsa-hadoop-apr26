import java.util.Scanner;
class Switch {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = in.nextInt();
		System.out.println("1.Square\n2.Cube\n3.Exit");
		System.out.print("Enter the choice: ");
		int choice = in.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Square:" + (num*num));
				break;
			case 2:
				System.out.println("Cube:" + (num*num*num));
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Wrong Choice!");
		}
	}
}
