package com.myblog.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StreamApiConsumerFunctional {

    public static void main(String[] args) {
        Consumer<Integer> result= number-> System.out.println(number);
        result.accept(100);

        List<String> names= Arrays.asList("Ravi","Shankar","Priti","Mishra");
        Consumer<String> value= name-> System.out.println(name);
        names.forEach(value);
    }
}
