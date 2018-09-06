package jdk8.function;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        FunctionDemo demo = new FunctionDemo();
        demo.simpleDemo();
        demo.composeAndThen();
    }

    public void simpleDemo(){
        Function<Integer,Integer> func = a -> a+2;
        System.out.println(func.apply(1));
    }

    public void composeAndThen(){
        Function<String,String> befor = name -> "befor 输入参数[" + name + "]";
        Function<String,String> after = name -> "after 输入参数[" + name + "]";

        System.out.println("compose:" + after.compose(befor).apply("demo"));
        System.out.println("andThen:" + befor.andThen(after).apply("demo"));
    }
}
