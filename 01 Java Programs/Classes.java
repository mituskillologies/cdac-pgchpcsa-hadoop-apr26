class Nation {					// Class name
	String name;            	// instance variables
	long population;
	
	Nation(String n, long p) {  // class constructor
		name = n;
		population = p;
	}
	void show() {    			// class method
		System.out.println("Name:"+name);
		System.out.println("Population:"+population);
	}
}
class Classes {
	public static void main(String arg[]) {
		Nation n1 = new Nation("Nepal", 5636665);
		n1.show();
		Nation n2 = new Nation("Sri Lanka", 6855666);
		n2.show();
	}
}
