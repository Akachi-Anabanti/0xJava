// Vehicle base Class

public class VehicleMain {
	static class Vehicle {
		public String starts(){
			return "Vehicle started";
		};
	}

	static class Car extends Vehicle {

		@Override
		public String starts() {
			return "Car started";
		}
	}

	static class Bike extends Vehicle {

		@Override
		public String starts(){
			return "Bike started";
		}
	}


	public static void main(String[] args) {

		// Vehicle refernce pointing to a car;
		Vehicle myVehicle = new Car();
		System.out.println(myVehicle.starts());

		// vehicle reference pointing to a Bike
		myVehicle = new Bike();
		System.out.println(myVehicle.starts());
	}
}
