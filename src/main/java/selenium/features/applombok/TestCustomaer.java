package selenium.features.applombok;

public class TestCustomaer {
	
	public static void main(String[] args) {
		Customers c1 = new Customers(1, "Arjun", 27, "Chennai");
		System.out.println(c1);
		System.out.println(c1.getName() + " "+ c1.getPlace());
		
		c1.setPlace("Bangalore");
		System.out.println(c1.getName() + " "+ c1.getPlace());
	}

}
