package com.myblog.myblog;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamApiSupplier {

    public static void main(String[] args) {

//        Supplier<Integer> num=()-> new Random().nextInt(500);
//        Integer result = num.get();
//        System.out.println(result);
//
//        List<Integer> numbers = Arrays.asList(10,20,40,50,70,60,80,300);
//        Supplier<Integer> numResult= () -> {
//            int index = new Random().nextInt(numbers.size());
//            return numbers.get(index);
//        };
//        System.out.println(numResult.get());

//        List<Employee> logins = Arrays.asList(
//                new Employee("ravi","test"),
//                new Employee("shankar","test"),
//                new Employee("ravi","test")
//        );
//
//        List<LoginDto> dtos= logins.stream().map(login->mapToDto(login)).collect(Collectors.toList());
//        System.out.println(dtos);

        List<Employee> employees= Arrays.asList(
                new Employee("Ravi",24,"Bettiah"),
                new Employee("Shankar",30,"Bettiah"),
                new Employee("Vikash",31,"Pune"),
                new Employee("Shyam",34,"Bengaluru")
        );

        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
        for(Employee e:emps){
            System.out.println("Name :"+e.getName());
            System.out.println("Age :"+e.getAge());
            System.out.println("City :"+e.getCity());
        }


        List<String> names=Arrays.asList("Ravi","Amisha","Ankit","Aman","Anshika","Shankar","Priti");
        System.out.println( names.stream().filter(name->name.startsWith("A")).collect(Collectors.toList()));

        List<Integer> numbers= Arrays.asList(10,20,30,40,54,21,84);
        List<Integer> collect = numbers.stream().filter(n -> n % 2 == 0).map(num -> num * num).collect(Collectors.toList());
        System.out.println(collect);

        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        for (Map.Entry<String,List<Employee>> entry:collect1.entrySet()){
            String city= entry.getKey();
            List<Employee> empCity=entry.getValue();
            System.out.println("City :"+city);
            System.out.println("---------------");

            for (Employee e: empCity)  {

                    System.out.println("Name :"+e.getName());
                    System.out.println("Age :"+e.getAge());
                    //System.out.println("City :"+e.getCity());
                System.out.println("---------------");

            }
        }


    }
//    static LoginDto mapToDto(Employee login){
//        LoginDto loginDto= new LoginDto();
//        loginDto.setUserName(login.getUserName());
//        loginDto.setPassword(login.getPassword());
//        return loginDto;
//    }
}
