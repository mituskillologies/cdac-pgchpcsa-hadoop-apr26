class Shape {					// Class name
	float area(float radius) {
		float a = 3.14f * radius * radius;
		return a;
	}
	int area(int side) {
		int a = side * side;
		return a;
	}
	int area(int len, int wid) {
		int a = len * wid;
		return a;
	}
}
class Overloading {
	public static void main(String arg[]) {
		Shape s1 = new Shape();
		System.out.println("Area of circle:" + s1.area(10.0f));
		System.out.println("Area of Square:" + s1.area(5));
		System.out.println("Area of Rectangle:" + s1.area(12,6));
	}
}
