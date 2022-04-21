package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class SCAN {
    private ArrayList<Integer> queue = new ArrayList<>() ;
    private int sizeOfQueue ;
    private int startHead ;
    private int finalTail ;
    private int cost;
    private boolean direction ;
    private ArrayList<Integer>sequence = new ArrayList<>() ;

    SCAN(int size , ArrayList<Integer>l , int start ,int end, boolean dir ){
        this.sizeOfQueue = size ;
        this.queue.addAll(l) ;
        this.startHead = start ;
        cost = 0 ;
        direction = dir ;
        finalTail = end ;
    }

    void operate(){
        queue.add(startHead);
        Collections.sort(queue);
        int index = queue.indexOf(startHead) ;

        if(direction){
            for(int i = index ; i <= sizeOfQueue ; ++i){
                sequence.add(queue.get(i));
            }
            sequence.add(finalTail);
            index-- ;
            for(int i = index ; i >= 0 ; --i){
                sequence.add(queue.get(i));
            }

        }else {
            for(int i = index ; i >= 0 ; --i){
                sequence.add(queue.get(i));
            }
            sequence.add(0);
            index++ ;
            for(int i = index ; i <= sizeOfQueue ; ++i){
                sequence.add(queue.get(i));
            }

        }

        for(int i = 0 ; i < sequence.size() - 1 ; ++i){
            cost += Math.abs( sequence.get(i) - sequence.get(i+1) ) ;
        }
        System.out.println(sequence);
        System.out.println("cost = " + cost);
        queue=sequence;
    }

    public ArrayList<Integer> getQueue() {
        return queue;
    }

    public int getCost() {
        return cost;
    }
}
