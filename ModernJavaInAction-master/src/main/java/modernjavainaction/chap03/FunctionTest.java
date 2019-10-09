package modernjavainaction.chap03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionTest {
    public static void main(String[] args) {
List<String> list = Arrays.asList("one","two","three");
List<Integer> list1 = transform(list,(String str)->str.length());
        System.out.println(list1);
    }

    interface Function<T,R>{
        R apply(T t);
    }

    public static <T, R> List<R> transform(List<T> list, Function<T, R> function) {
        List<R> results = new ArrayList<>();
        for(T t:list){
            results.add(function.apply(t));
        }
        return results;
    }
}
