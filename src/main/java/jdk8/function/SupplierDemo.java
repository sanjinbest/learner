package jdk8.function;

import java.util.UUID;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<String> uuid = () -> UUID.randomUUID().toString();
        Supplier<String> timestamp = () -> System.currentTimeMillis() + "";

        SupplierDemo supplierDemo = new SupplierDemo();
        System.out.println("uuid-sessionId : " + supplierDemo.sessionId(uuid));
        System.out.println("timestamp-sessionId : " + supplierDemo.sessionId(timestamp));
    }

    /**
     * 可自义的session_id生成器
     * @param supplier
     * @return
     */
    public String sessionId(Supplier<String> supplier){
        return supplier.get();
    }
}
