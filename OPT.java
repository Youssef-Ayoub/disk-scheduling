package com.company;

import java.util.ArrayList;
import java.util.Collections;


public class OPT {
    private ArrayList<Integer> queue = new ArrayList<>() ;
    private int sizeOfQueue ;
    private int startHead ;
    private int cost;

    OPT(int size , ArrayList<Integer>l , int start){
        this.sizeOfQueue = size ;
        this.startHead = 0 ;
        this.queue.addAll(l) ;
        cost = 0 ;
    }

    void operate(){
        queue.add(startHead);
        Collections.sort(queue);
        for(int i = 0 ; i < queue.size() - 1 ; ++i){
            cost += Math.abs(queue.get(i) - queue.get(i+1) ) ;
        }
        System.out.println(queue);
        System.out.println(cost);
    }

    public ArrayList<Integer> getQueue() {
        return queue;
    }

    public int getCost() {
        return cost;
    }


}
