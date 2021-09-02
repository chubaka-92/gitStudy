package ru.study.java.sandbox;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class MyStack {
    public static void main(String[] args) {
        Person pers1 = new Person(1);
        Person pers2 = new Person(2);
        Person pers3 = new Person(3);
        Person pers4 = new Person(4);
        Person pers5 = new Person(5);

        Stack<Person> stack = new Stack<>();

        stack.push(pers1);
        stack.push(pers4);
        stack.push(pers3);
        stack.push(pers5);
        stack.push(pers2);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
/*        for (Person pers : stack) {
            System.out.println(pers.pop());
        }*/
        System.out.println("*******************");
    }
}

/*class Person{
    private int id;
    public Person(int id){
        this.id=id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}*/
