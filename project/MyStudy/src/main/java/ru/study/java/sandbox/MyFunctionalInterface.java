package ru.study.java.sandbox;

import java.util.Scanner;
import java.util.function.*;

public class MyFunctionalInterface {
    public static void main(String[] args) {

        System.out.println("Predicate");
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false
        System.out.println("*********************");

        System.out.println("BinaryOperator");
        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20
        System.out.println("*********************");

        System.out.println("UnaryOperator");
        UnaryOperator<Integer> square = x -> x*x;
        System.out.println(square.apply(5)); // 25
        System.out.println("*********************");

        System.out.println("Function");
        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";
        System.out.println(convert.apply(5)); // 5 долларов
        System.out.println("*********************");

        System.out.println("Consumer");
        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);
        printer.accept(600); // 600 долларов

        Consumer<String> printer2 = System.out::println;//= string-> System.out.println(string);
        printer2.accept("Хеллоу Ворлд");
        System.out.println("*********************");

        System.out.println("Supplier");
            Supplier<User> userFactory = ()->{

                Scanner in = new Scanner(System.in);
                System.out.println("Введите имя: ");
                String name = in.nextLine();
                return new User(name);
            };

            User user1 = userFactory.get();
            User user2 = userFactory.get();

            System.out.println("Имя user1: " + user1.getName());
            System.out.println("Имя user2: " + user2.getName());
        }
    }

class User{

    private String name;
    String getName(){
        return name;
    }

    User(String n){
        this.name=n;
    }
}
