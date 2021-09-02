package ru.tinkoff.study;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkString {
    public static void main(String[] args) {

        int nSet; //Кол-во наборов
        ArrayList<String> list = new ArrayList<String>(); // Список Наборов данных
        String set = null; // набор данных

        Scanner scan = new Scanner(System.in);

        System.out.print("Введите количество наборов входных данных: ");

        nSet = Integer.parseInt(scan.nextLine());

        if (nSet >= 1 && nSet<=100){

            for (int i = 1; i <= nSet; i++) {
                System.out.print("Введите набор "+ i + " :");
                set = scan.nextLine();

                if(set.length() == 4 && set.matches("[A-Z]+")){
                    list.add(set);

                } else {
                    System.out.println("Вводи большие латинские буковки, и у тебя все получится!.");
                    i--;
                }
            }

            for (int i = 0; i <= nSet-1; i++){
                System.out.println(list.get(i) + " " + checkString(list.get(i)));
            }

        }else {
            System.out.print("Такое колическтво наборов не допустимо!");

        }
        scan.close();

    }


    public static String checkString(String str){
        String repStr;

        repStr = str.replace(String.valueOf(str.charAt(0)),"");

        if(repStr.length()==2 && repStr.charAt(0)==repStr.charAt(0)){
            return "Yes";
        } else {
            return "No";
        }
    }
}
