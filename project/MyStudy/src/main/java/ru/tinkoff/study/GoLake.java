package ru.tinkoff.study;

import java.util.ArrayList;
import java.util.Scanner;

public class GoLake {
    public static void main(String[] args) {
        /**
         * k - периметр озера
         * n - количество деревень
         * list - массив с растояниями деревень
         */

        int k;
        int n;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите Периметр озера и Кол-во деревень: ");

        k = scan.nextInt();
        n = scan.nextInt();

        if(validate(k, n) == true){
            int a; //растоянние до деревни
            int nV = 1; // текущий номер деревни
            for (int i = 0; i <= n-1; i++){
                System.out.println("Введите введите растояние до Деревни:" + nV);

                a = scan.nextInt();

                if(i==0 && a>=0 && a<=k){
                    list.add(0, a);
                    nV++;
                } else
                if(i>0 && a>=0 && a<=k){
                    list.add(i, a);
                    nV++;
                }else {
                    System.out.println("данные коардинат Деревни " + nV + " не корректны");
                }
            }

            System.out.print("Из какой деревни стартуем? ");

            int villFrom = scan.nextInt();
            if(villFrom>n || villFrom<=0){
                System.out.println("Такой деревни нет.");

            } else {
                System.out.println("Кратчайший путь составляет: " + calculatePath(k, list, villFrom));
            }

        }
        scan.close();
    }

    public static boolean validate(int k, int n){
        if (k < 2 || k>1000000){
            System.out.println("Периметр озера введен некоректно.");
            return false;
        }
        if (n < 2 || n>2*100000){
            System.out.println("Количество деревень введен некоректно.");
            return false;
        }
        return true;
    }

    public static int calculatePath(int k, ArrayList<Integer> list, int villFrom){
        int result1=0;
        int result2=0;

        if(villFrom != 1 && villFrom != list.size()) {
            result1 = k - (list.get(villFrom - 1) - list.get(villFrom - 2));

            result2 = k - (list.get(villFrom) - list.get(villFrom - 1));
        }

        //для первой деревни
        if(villFrom == 1) {
            result1 = list.get(list.size()-1) - list.get(0);

            result2 = k - (list.get(villFrom) - list.get(0));
        }

        //для последней деревни
        if(villFrom == list.size()) {
            result1 = list.get(list.size()-1) - list.get(0);

            result2 = k - (list.get(villFrom-1) - list.get(villFrom - 2));
        }

        if (result1>result2){
            return result2;
        } else {
            return result1;
        }

    }
}
