package com.myblog.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiFunction {

    public static void main(String[] args) {
//        Function<String,Integer> result = str->str.length();
//        Integer val = result.apply("mike");
//        System.out.println(val);
        Function<Integer,Integer> result = i->i*10;
        Integer val = result.apply(20);
        System.out.println(val);

        List<Integer> datas= Arrays.asList(10,20,50,31,21,52);
        List<Integer> newDatas = datas.stream().map(i -> i + 10).collect(Collectors.toList());
        System.out.println(newDatas);

        List<String> names = Arrays.asList("Ravi","Shankar","Priti","Mishra","Amisha");
        List<String> newNames = names.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        System.out.println(newNames);

        List<String> unsortedNames = Arrays.asList("Ravi","Shankar","Priti","Mishra","Amisha");
        List<String> sortedNames = unsortedNames.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNames);

        List<Integer> unsortedNumbers= Arrays.asList(111,10,12,85,9,41,12,45,74,1);
        List<Integer>  sortedNumbers = unsortedNumbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);

        List<Integer> numbers= Arrays.asList(111,10,12,85,9,41,12,45,74,1,10,45,111);
        List<Integer>  uniqueNumber = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNumber);

    }
}
