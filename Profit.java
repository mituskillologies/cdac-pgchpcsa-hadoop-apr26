// Write the program to check whether we got the profit or loss and how much.
/*
	Date: 4/4/2026
*/

// The if - else statement
// Relational Operators

class Profit {
	public static void main(String arg[]) {
		float purchase_cost = 1340.0f, selling_cost = 1500.0f;
		if (purchase_cost < selling_cost) {
			System.out.println("Profit: " + (selling_cost-purchase_cost));
		}
		else {
			System.out.println("Loss: " + (purchase_cost-selling_cost));
		}
	}
}
