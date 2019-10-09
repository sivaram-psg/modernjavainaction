package modernjavainaction.chap03;

import scala.Int;

import java.util.Arrays;
import java.util.List;

public class ConsumerTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        foreach(list,(Integer t)-> System.out.println(t));
    }
    interface Consumer<T>{
        void accept(T t);
    }
    static <T> void  foreach(List<T> lists,Consumer<T> consumer){
        for(T t:lists){
            consumer.accept(t);
        }
    }
}
