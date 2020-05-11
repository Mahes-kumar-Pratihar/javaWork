package diet;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Represents a recipe of the diet.
 * 
 * A recipe consists of a a set of ingredients that are given amounts of raw
 * materials. The overall nutritional values of a recipe can be computed on the
 * basis of the ingredients' values and are expressed per 100g
 * 
 *
 */
public class Recipe implements NutritionalElement {

	/**
	 * Adds a given quantity of an ingredient to the recipe. The ingredient is a raw
	 * material.
	 * 
	 * @param material the name of the raw material to be used as ingredient
	 * @param quantity the amount in grams of the raw material to be used
	 * @return the same Recipe object, it allows method chaining.
	 */
	private String name;
	Food food;
	private double calories = 0.0;
	private double proteins = 0.0;
	private double carbs = 0.0;
	private double fat = 0.0;
	private double weight = 0.0;
	
	private TreeMap<String, Double> ingredients = new TreeMap<String, Double>();

	public Recipe(String name, Food food) {
		this.food = food;
		this.name = name;
	}

	public Recipe addIngredient(String material, double quantity) {
		
		NutritionalElement n = this.food.getRawMaterial(material);
		
		this.calories += n.getCalories() * quantity/100;
		this.proteins += (quantity / 100) * n.getProteins();
		this.carbs += n.getCarbs() * quantity/100;
		this.fat += n.getFat() / 100 * quantity;
		this.weight += quantity;
		
		this.ingredients.put(material, quantity);
		return this;
	}

	public TreeMap<String, Double> getIngredients() {
		return ingredients;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getCalories() {
		
		return calories;
	}

	@Override
	public double getProteins() {
		
		return this.proteins;
	}

	@Override
	public double getCarbs() {
	
		return this.carbs;
	}

	@Override
	public double getFat() {
		
		return this.fat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods refer
	 * to a conventional 100g quantity of nutritional element, or to a unit of
	 * element.
	 * 
	 * For the {@link Recipe} class it must always return {@code true}: a recipe
	 * expresses nutritional values per 100g
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return true;
	}

	/**
	 * Returns the ingredients composing the recipe.
	 * 
	 * A string that contains all the ingredients, one per per line, using the
	 * following format: {@code "Material : ###.#"} where <i>Material</i> is the
	 * name of the raw material and <i>###.#</i> is the relative quantity.
	 * 
	 * Lines are all terminated with character {@code '\n'} and the ingredients must
	 * appear in the same order they have been added to the recipe.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (Entry<String, Double> e : ingredients.entrySet()) {
			sb.append(e.getKey()).append(" : ").append(e.getValue()).append('\n');
		}

		return sb.toString();
	}
}
