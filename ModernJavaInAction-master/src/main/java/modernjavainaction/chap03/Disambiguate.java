package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Disambiguate {
    public static void main(String[] args) {
        int portNumber = 2234;
        Runnable runnable = ()-> System.out.println(portNumber);
        execute((Runnable) ()-> System.out.println("runnable"));
        execute((Action)()-> System.out.println("action"));
        List<String> list = Arrays.asList("A","b","a","B");
        //list.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        list.sort(String::compareToIgnoreCase);
        System.out.println(list);
        List<Integer> weights = Arrays.asList(1,2,3);
        List<Apple> apples = map(weights,Apple::new);
        System.out.println(apples);
        BiFunction<Integer,Color,Apple> function = Apple::new;
        System.out.println(function.apply(4,Color.RED));

    }

    static List<Apple> map(List<Integer> weights, Function<Integer,Apple> function){
        List<Apple> result = new ArrayList<>();
        for(Integer integer:weights){
            result.add(function.apply(integer));
        }
        return result;
    }
    static void execute(Runnable r){
        r.run();
    }

    static void execute(Action action){
        action.act();
    }
    interface Action{
        void act();
    }
}
