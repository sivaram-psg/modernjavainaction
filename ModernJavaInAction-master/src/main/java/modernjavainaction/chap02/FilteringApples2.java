package modernjavainaction.chap02;

import scala.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FilteringApples2 {

  public static void main(String... args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, Color.GREEN),
        new Apple(155, Color.GREEN),
        new Apple(120, Color.RED));

    // [Apple{color=GREEN, weight=80}, Apple{color=GREEN, weight=155}]
    List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
    System.out.println(greenApples);

    // [Apple{color=RED, weight=120}]
    List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
    System.out.println(redApples);

    List<Apple> greenApples2 = filter(inventory,new AppleGreenColorPredicate());
    System.out.println(greenApples2);

    List<Apple> heavyApples = filter(inventory,new AppleHeavyPredicate());
    System.out.println(heavyApples);

   formatApple(inventory,new SimpleAppleFormatter());

    Thread thread = new Thread(()-> System.out.println("test thread"));
  }

  public static List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getColor() == Color.GREEN) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getColor() == color) {
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (apple.getWeight() > weight) {
        result.add(apple);
      }
    }
    return result;
  }

  public static void formatApple(List<Apple> inventory,AppleFormatter formatter){
    List<String> strings = new ArrayList<>();
    for(Apple apple:inventory){
      System.out.println(formatter.accept(apple));
    }
      }

  public static List<Apple> filter(List<Apple> inventory,ApplePredicate predicate){
    List<Apple> result = new ArrayList<>();

    for(Apple apple:inventory){
      if(predicate.test(apple)){
        result.add(apple);
      }
    }
    return result;
  }

  enum Color {
    RED,
    GREEN
  }

  public static class Apple {

    private int weight = 0;
    private Color color;

    public Apple(int weight, Color color) {
      this.weight = weight;
      this.color = color;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public Color getColor() {
      return color;
    }

    public void setColor(Color color) {
      this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
      return String.format("Apple{color=%s, weight=%d}", color, weight);
    }

  }

interface ApplePredicate{
    boolean test(Apple apple);
}

static class AppleGreenColorPredicate implements ApplePredicate{

  @Override
  public boolean test(Apple apple) {
    return apple.getColor().equals(Color.GREEN);
  }
}

static class AppleHeavyPredicate implements ApplePredicate{

  @Override
  public boolean test(Apple apple) {
    return apple.getWeight()>150;
  }
}

interface AppleFormatter{
    String accept(Apple apple);
}

static class SimpleAppleFormatter implements AppleFormatter{

  @Override
  public String accept(Apple apple) {
    return "An apple of "+apple.getWeight()+"g";
  }
}
}
