package com.myblog.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiPredicate {

    public static void main(String[] args) {

//        Predicate<Integer> pre = x->x%2==0;
//        boolean test = pre.test(10);
//        System.out.println(test);
//        Predicate<String> pre= str-> str.equals("ravi");
//        boolean result = pre.test("ravi");
//        System.out.println(result);
//        List<Integer> numbers = Arrays.asList(10, 20, 30, 15, 45, 58, 56, 46,31,21);
//        List<Integer> oddNumbers = numbers.stream().filter(n -> n % 2 == 1).collect(Collectors.toList());
//        System.out.println(oddNumbers);
        List<String> names = Arrays.asList("ravi","shankar","ravi","manish","mike");
        List<String> name = names.stream().filter(str->str.startsWith("r")).collect(Collectors.toList());
        List<String> eqname = names.stream().filter(str->str.equals("ravi")).collect(Collectors.toList());
        System.out.println(name);
        System.out.println(eqname);

    }
}
