class Shape {					// Super class
	float pi = 3.14f;
	int radius;
	Shape(int radius) {
		this.radius = radius;
	}
	void display() {
		System.out.println("Value of Pi: " + pi);
	}
}
class Circle extends Shape {   // Sub class
	Circle(int r) {
		super(r);
	}
	void area() {
		float a = pi * radius * radius;
		System.out.println("Area of circle is:" + a);
	}
}
class Inheritance1 {
	public static void main(String arg[]) {
		Circle c1 = new Circle(7);
		c1.display();
		c1.area();
	}
}
