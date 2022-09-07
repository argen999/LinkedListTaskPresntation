package main;

import shablon.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Animal> linkedList = new LinkedList<>();


        for (int i = 0; i < 100; i++) {
            linkedList.add(new Cat("Tom"+i, random.nextInt(1,9) ) );
            linkedList.add(new Dog("Rex"+i, random.nextInt(1,9) ) );
        }
        int counter = 0, cat = 5, dog = 0, dog1 = 4;
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) instanceof Cat) {
                 counter++;
            }
            if (counter == cat) {
                linkedList.remove(i);
                cat += 5;
            }
            if (linkedList.get(i) instanceof Dog) {
                dog++;
                if (dog == dog1) {
                    linkedList.add(i,new Mouse("Mise", random.nextInt(1,9) ) );
                    dog1 += 4;
                }
            }
        }
        LinkedList<Animal> linkedList1 = new LinkedList<>();
        for (int j = 0; j < linkedList.size(); j++) {
            if (linkedList.get(j) instanceof Mouse && linkedList.get(j-1) instanceof Cat) {
                linkedList1.add(linkedList.get(j-1) );
                linkedList.remove(j-1);
            }
        }
        for (Animal a: linkedList) {
            System.out.println(a.getName() );
        }
        System.out.println("---------Мышыктар!---------");
        for (Animal a: linkedList1) {
            System.out.println(a.getName() );
        }
        System.out.println("---------Баары ArrayList те---------");


        ArrayList<Animal> arrayList = new ArrayList<>(linkedList);
        for (Animal a : arrayList) {
            System.out.println(a.getName());
        }
        System.out.println("-----------Жаштарынын суммасы!------------");
        int summa = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            summa += arrayList.get(i).getAge();
        }
        System.out.println(summa+"!");
//        Animal[] animals = linkedList.toArray(new Animal[100]);
//        for (Animal a : animals) {
//            System.out.println(a.getName());
//        }
        System.out.println("Эми сорттолушу: Биринчи мышыктар, Экинчи иттер, Учунчу чычкандар!");

    }

    
}