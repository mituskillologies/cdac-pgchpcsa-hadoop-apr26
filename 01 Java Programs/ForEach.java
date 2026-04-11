import java.util.Scanner;
class ForEach {
	public static void main(String [] args) {
		int num[] = {54,33,12,3,5,66,26};
		int add = 0;
		for (int n : num) {
			add += n;
		}
		System.out.println("Addition:" + add);
	}
}
