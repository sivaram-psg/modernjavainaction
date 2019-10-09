package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredicateTest {
    public static void main(String[] args) {
List<String> inventory = Arrays.asList("one","","three");
 Predicate<String> nonEmptyStringPredicate = (String t)->!t.isEmpty();
 List<String> nonEmptyStrings = filter(inventory,nonEmptyStringPredicate);
        System.out.println(nonEmptyStrings);
    }
    interface Predicate<T>{
        boolean test(T t);
    }

    static <T> List<T> filter(List<T> inventory,Predicate<T> predicate){
        List<T> results = new ArrayList<>();
        for(T t:inventory){
            if(predicate.test(t)){
                results.add(t);
            }
        }
        return results;
    }
}
