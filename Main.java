package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Integer>list = new ArrayList<Integer>() ;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number of requests ahead");
        int n = input.nextInt() ;

        System.out.println("enter the head start");
        int head = input.nextInt() ;

        System.out.println("enter the disk queue");

        for(int i = 0 ; i < n ; ++i){
            list.add( input.nextInt() );
        }

        FCFS obj1 = new FCFS(n,list,head) ;
        obj1.operate();

        SCAN obj2 = new SCAN(n,list,head,200,false) ;
        //last parameter is for direction of scan
        // if direction is true then it will move right first else it will move left first
        obj2.operate();

        LOOK obj3 = new LOOK(n,list,head,false) ;
        //last parameter is for direction of scan
        // if direction is true then it will move right first else it will move left first
        obj3.operate();

        OPT obj4 = new OPT(n,list,head) ;
        obj4.operate();

    }
}


//38
//180
//130
//10
//50
//15
//190
//90
//150
