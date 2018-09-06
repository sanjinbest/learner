package jdk8.function;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        PredicateDemo predicateDemo = new PredicateDemo();
        predicateDemo.simpleDemo();
    }

    public void simpleDemo(){
        Predicate<Integer> predicate = i -> i > 10;
        Predicate<Integer> other = i -> i < 20;

        Integer param = 10;
        String str = "demo";

        System.out.println(param + ">10：" + predicate.test(param));
        System.out.println(param + " > 10 and " + param + " < 20：" + predicate.and(other).test(111));
        System.out.println(param + " > 10 or " + param + " < 20：" + predicate.or(other).test(30));
        System.out.println("!("+param+" > 10)：" + predicate.negate().test(0));
        System.out.println("demo.equal("+str+")：" + Predicate.isEqual("demo").test("demo"));
    }

}
