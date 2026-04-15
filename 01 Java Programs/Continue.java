class Continue {
	public static void main(String arg[]) {
		int i = 0;
		
		for( i = 0; i < 10; i++) {               
			if(i == 5)
				continue;
			System.out.println(i);
		}
	}
}
