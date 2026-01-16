import java.util.*;
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Meal<VegetarianMeal> vegMeal = new Meal<VegetarianMeal>();

        Meal<VeganMeal> veganMeal = new Meal<VeganMeal>();

        System.out.print("enter vegetarian meal name: ");
        String vegName = scn.nextLine();
        VegetarianMeal vm = new VegetarianMeal(vegName);
        vegMeal.addMeal(vm);

        System.out.print("enter vegan meal name: ");
        String veganName = scn.nextLine();
        VeganMeal vgm = new VeganMeal(veganName);

        veganMeal.addMeal(vgm);
        System.out.println("\nmeal plans generated:");
        generateMealPlan(vegMeal.getMeals());
        generateMealPlan(veganMeal.getMeals());
    }

    // generic method for validation
    public static <T extends MealPlan> void generateMealPlan(List<T> list) {
        for (MealPlan m : list) {
            System.out.println(m.getMealDetails());
        }
    }
}

interface MealPlan {

    String getMealDetails();
}

// vegetarian meal class
class VegetarianMeal implements MealPlan {

    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    // overriding method
    public String getMealDetails() {
        return "vegetarian meal: " + mealName;
    }
}

// vegan meal class
class VeganMeal implements MealPlan {

    private String mealName;
    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    // overriding method
    public String getMealDetails() {
        return "vegan meal: " + mealName;
    }
}

// keto meal class
class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }
    public String getMealDetails() {
        return "keto meal: " + mealName;
    }
}

// high protein meal class
class HighProteinMeal implements MealPlan {
    private String mealName;
    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    // overriding method
    public String getMealDetails() {
        return "high protein meal: " + mealName;
    }
}

// generic meal handler
class Meal<T extends MealPlan> {
    private List<T> meals;
    public Meal() {
        meals = new ArrayList<T>();
    }

    public void addMeal(T meal) {
        meals.add(meal);
    }

    // getter for meal list
    public List<T> getMeals() {
        return meals;
    }
}
