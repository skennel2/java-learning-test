package org.almansa.app.java.stream.reduce;

public class Dish {
    private String name;
    private int calories;
    private boolean isVegetarian;

    public Dish(String name, int calories, boolean isVegetarian) {
        super();
        this.name = name;
        this.calories = calories;
        this.isVegetarian = isVegetarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean isVegetarian) {
        this.isVegetarian = isVegetarian;
    }

}
