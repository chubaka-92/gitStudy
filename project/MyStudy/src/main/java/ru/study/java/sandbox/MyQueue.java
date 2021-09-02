package ru.study.java.sandbox;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MyQueue {
    public static void main(String[] args) {
        Person pers1 = new Person(1);
        Person pers2 = new Person(2);
        Person pers3 = new Person(3);
        Person pers4 = new Person(4);
        Person pers5 = new Person(5);

        Queue<Person> peersons = new LinkedList<>();

        peersons.add(pers1);
        peersons.add(pers4);
        peersons.add(pers3);
        peersons.add(pers5);
        peersons.add(pers2);

        for (Person person : peersons) {
            System.out.println(person);
        }
        System.out.println("*******************");
        Queue<Person> peersonsBlock = new ArrayBlockingQueue<Person>(5);
        peersonsBlock.add(pers1);
        peersonsBlock.add(pers4);
        peersonsBlock.add(pers3);
        peersonsBlock.add(pers5);
        peersonsBlock.add(pers2);

        peersonsBlock.stream().forEach(System.out::println);
        for (Person person : peersonsBlock) {
            System.out.println(person);

        }
        System.out.println("*******************");
        //удалим первый элемент в очереди
        System.out.println(peersonsBlock.remove());
        System.out.println("*******************");
        System.out.println(peersonsBlock);
        System.out.println("*******************");
        //посмотреть первый элемент в очереди(не удаляя)
        System.out.println(peersonsBlock.peek());
        System.out.println(peersonsBlock.element());
        System.out.println("*******************");

    }
}

class Person{
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
}
