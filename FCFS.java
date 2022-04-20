package com.company;

import java.util.*;

public class FCFS {
    private ArrayList<Integer>queue = new ArrayList<>() ;
    private int sizeOfQueue ;
    private int startHead ;
    private int cost;

    FCFS(int size , ArrayList<Integer>l , int start){
        this.sizeOfQueue = size ;
        this.startHead = start ;
        this.queue.addAll(l) ;
        cost = 0 ;
    }

    void operate(){
        queue.add(0 ,startHead);
        System.out.println(queue);
        for(int i = 0 ; i < sizeOfQueue ; ++i){
            cost += Math.abs(queue.get(i) - queue.get(i+1) ) ;
        }

        System.out.println("cost = " + cost);

    }


    public ArrayList<Integer> getQueue() {
        return queue;
    }

    public int getCost() {
        return cost;
    }
}
