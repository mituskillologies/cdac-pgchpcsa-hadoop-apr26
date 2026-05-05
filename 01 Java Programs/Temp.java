// Write the program to convert the fahrenhite temp to centigrade
/*
	Date: 4/4/2026
*/

class Temp {
	public static void main(String arg[]) {
		float fah = -40.0f, cent;
		
		cent = (fah - 32) * (5.0f / 9.0f);
		
		System.out.println("Celcius is: " + cent);
	}
}
