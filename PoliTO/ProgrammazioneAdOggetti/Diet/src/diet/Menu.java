package diet;

/**
 * Represents a complete menu.
 * 
 * It can be made up of both packaged products and servings of given recipes.
 *
 */
public class Menu implements NutritionalElement {
	
	protected String name;
	protected Food foods;
	protected double calories;
	protected double proteins;
	protected double carbs;
	protected double fat;

	public Menu(Food foods, String name) {
		this.name = name;
		this.foods = foods;
		this.calories = 0.0;
		this.proteins = 0.0;
		this.carbs = 0.0;
		this.fat = 0.0;
	}
	/**
	 * Adds a given serving size of a recipe.
	 * The recipe is a name of a recipe defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param recipe the name of the recipe to be used as ingredient
	 * @param quantity the amount in grams of the recipe to be used
	 * @return the same Menu to allow method chaining
	 */
    public Menu addRecipe(String recipe, double quantity) {
    	NutritionalElement rec;
    	rec = foods.getRecipe(recipe);
		this.calories += rec.getCalories() * quantity / 100;
		this.proteins += rec.getProteins() * quantity / 100;
		this.carbs += rec.getCarbs() * quantity / 100;
		this.fat += rec.getFat() * quantity / 100;
		return this;
	}

	/**
	 * Adds a unit of a packaged product.
	 * The product is a name of a product defined in the {@code food}
	 * argument of the constructor.
	 * 
	 * @param product the name of the product to be used as ingredient
	 * @return the same Menu to allow method chaining
	 */
    public Menu addProduct(String product) {
    	NutritionalElement prod;
    	prod = foods.getProduct(product);
    	this.calories += prod.getCalories();
    	this.proteins += prod.getProteins();
    	this.carbs += prod.getCarbs();
    	this.fat += prod.getFat();
		return this;
	}

	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Total KCal in the menu
	 */
	@Override
	public double getCalories() {
		return this.calories;
	}

	/**
	 * Total proteins in the menu
	 */
	@Override
	public double getProteins() {
		return this.proteins;
	}

	/**
	 * Total carbs in the menu
	 */
	@Override
	public double getCarbs() {
		return this.carbs;
	}

	/**
	 * Total fats in the menu
	 */
	@Override
	public double getFat() {
		return this.fat;
	}

	/**
	 * Indicates whether the nutritional values returned by the other methods
	 * refer to a conventional 100g quantity of nutritional element,
	 * or to a unit of element.
	 * 
	 * For the {@link Menu} class it must always return {@code false}:
	 * nutritional values are provided for the whole menu.
	 * 
	 * @return boolean indicator
	 */
	@Override
	public boolean per100g() {
		return false;
	}
}

//=====================================================
//=====================================================
//=====================================================

// package diet;

// /**
//  * Represents a complete menu.
//  * 
//  * It can be made up of both packaged products and servings of given recipes.
//  *
//  */
// public class Menu implements NutritionalElement {

// 	/**
// 	 * Adds a given serving size of a recipe.
// 	 * The recipe is a name of a recipe defined in the {@code food}
// 	 * argument of the constructor.
// 	 * 
// 	 * @param recipe the name of the recipe to be used as ingredient
// 	 * @param quantity the amount in grams of the recipe to be used
// 	 * @return the same Menu to allow method chaining
// 	 */
//     public Menu addRecipe(String recipe, double quantity) {
// 		return null;
// 	}

// 	/**
// 	 * Adds a unit of a packaged product.
// 	 * The product is a name of a product defined in the {@code food}
// 	 * argument of the constructor.
// 	 * 
// 	 * @param product the name of the product to be used as ingredient
// 	 * @return the same Menu to allow method chaining
// 	 */
//     public Menu addProduct(String product) {
// 		return null;
// 	}

// 	@Override
// 	public String getName() {
// 		return null;
// 	}

// 	/**
// 	 * Total KCal in the menu
// 	 */
// 	@Override
// 	public double getCalories() {
// 		return -1.0;
// 	}

// 	/**
// 	 * Total proteins in the menu
// 	 */
// 	@Override
// 	public double getProteins() {
// 		return -1.0;
// 	}

// 	/**
// 	 * Total carbs in the menu
// 	 */
// 	@Override
// 	public double getCarbs() {
// 		return -1.0;
// 	}

// 	/**
// 	 * Total fats in the menu
// 	 */
// 	@Override
// 	public double getFat() {
// 		return -1.0;
// 	}

// 	/**
// 	 * Indicates whether the nutritional values returned by the other methods
// 	 * refer to a conventional 100g quantity of nutritional element,
// 	 * or to a unit of element.
// 	 * 
// 	 * For the {@link Menu} class it must always return {@code false}:
// 	 * nutritional values are provided for the whole menu.
// 	 * 
// 	 * @return boolean indicator
// 	 */
// 	@Override
// 	public boolean per100g() {
// 		return false;
// 	}
// }