package modernjavainaction.chap01;

import scala.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringApples2 {

  public static void main(String... args) {
    List<Apple> inventory = Arrays.asList(
        new Apple(80, "green"),
        new Apple(155, "green"),
        new Apple(120, "red")
    );

    List<Apple> greenApples = filterGreenApple(inventory);
    System.out.println(greenApples);

    List<Apple> heavyApples = filterHeavyApple(inventory);
    System.out.println(heavyApples);

    List<Apple> greenApple2 = filterApple(inventory,FilteringApples2::filterGreen);
    System.out.println(greenApple2);

    List<Apple> greenApple3 = filterApple(inventory,(Apple a)->a.getColor().equals("green"));
    System.out.println(greenApple3);

    List<Apple>  heavyApples2 = inventory.stream()
                                .filter(a->a.getWeight()>100)
                                .collect(Collectors.toList());
    System.out.println(heavyApples2);

  }

  interface Predicate<Apple> {
    boolean test(Apple apple);
  }

  static boolean filterGreen(Apple apple){
    return apple.getColor().equals("green");
  }
  static List<Apple> filterApple(List<Apple> inventory,Predicate<Apple> predicate){
    List<Apple> result = new ArrayList<>();
    for(Apple apple : inventory){
      if(predicate.test(apple)){
        result.add(apple);
      }
    }
    return result;
  }
public static List<Apple> filterGreenApple(List<Apple> inventory){

    List<Apple> result = new ArrayList<>();
    for(Apple apple:inventory){
      if(apple.getColor().equals("green")){
        result.add(apple);
      }
    }
    return result;
  }

  public static List<Apple> filterHeavyApple(List<Apple> inventory){
    List<Apple> result = new ArrayList<>();
    for(Apple apple:inventory){
      if(apple.getWeight()>150){
        result.add(apple);
      }
    }
    return result;
  }
  public static class Apple {

    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
      this.weight = weight;
      this.color = color;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(int weight) {
      this.weight = weight;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
      return String.format("Apple{color='%s', weight=%d}", color, weight);
    }

  }

}
