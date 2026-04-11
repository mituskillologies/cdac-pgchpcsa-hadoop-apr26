import java.util.Scanner;
class DoWhile {
	public static void main(String [] args) {
		int num[] = {54,33,12,3,5,66,26};
		int add = 0, i =0;
		do {
			add += num[i];
			i++;
		} while(i < num.length);
		
		System.out.println("Addition:" + add);
	}
}
