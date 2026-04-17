interface Data {
	public float pi = 3.14f;
	public float area(float radius);
}
interface Info {
	public void display(float radius);
}
class Circle implements Data, Info {
	public float area(float radius) {
		float a = pi * radius * radius;
		return a;
	}
	public void display(float radius) {
		float a = area(radius);
		System.out.println("Area: " + a);
	}
}
class Iface {
	public static void main(String arg[]) {
		Circle c1 = new Circle();
		c1.display(4.5f);
	}
}
