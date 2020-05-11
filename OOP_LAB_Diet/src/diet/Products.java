package diet;

public class Products implements NutritionalElement {
	String name;
	double calories;
	double proteins;
	double carbs;
	double fat;
	
	public Products(String name, double calories, double proteins, double carbs, double fat) {
		this.name = name;
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.fat = fat;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public double getCalories() {
		// TODO Auto-generated method stub
		return this.calories;
	}

	@Override
	public double getProteins() {
		// TODO Auto-generated method stub
		return this.proteins;
	}

	@Override
	public double getCarbs() {
		// TODO Auto-generated method stub
		return this.carbs;
	}

	@Override
	public double getFat() {
		// TODO Auto-generated method stub
		return this.fat;
	}

	@Override
	public boolean per100g() {
		// TODO Auto-generated method stub
		return false;
	}
}
