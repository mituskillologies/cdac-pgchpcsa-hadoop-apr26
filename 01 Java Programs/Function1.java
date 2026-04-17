class Function1 {
	int square(int n) {
		int sq;
		sq = n * n;
		return(sq);
	}
	boolean isOdd(int n) {
		if (n % 2 == 1) 
			return(true);
		else
			return(false);
	}
	public static void main(String arg[]) {
			Function1 f = new Function1(); // Create class object
			int num = f.square(15);        // Call method
			System.out.println("Square is: " + num);
			System.out.println("Odd: " + f.isOdd(num));
	}
}
