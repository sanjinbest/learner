package jdk8.function;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FibonacciDemo {

    static Map<Integer, Integer> cache = new ConcurrentHashMap<>();


    public static void main(String[] args) {
        cache.put(0, 0);
        cache.put(1, 1);

        long s = System.currentTimeMillis();
        System.out.println(fibonacci(15));
        System.out.println("===================  "+(System.currentTimeMillis() - s));

        s = System.currentTimeMillis();
        System.out.println(fibonacciJava8(15));
        System.out.println("===================  "+(System.currentTimeMillis() - s));
    }

    static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;

//        System.out.println("calculating Fibonacci(" + n + ")");
        return fibonacci(n - 2) + fibonacci(n - 1);
    }

    static int fibonacciJava8(int n) {
        return cache.computeIfAbsent(n, (key) -> {
            System.out.println("calculating FibonacciJava8 " + n);
            return fibonacciJava8(n - 2) + fibonacciJava8(n - 1);
        });
    }


}
