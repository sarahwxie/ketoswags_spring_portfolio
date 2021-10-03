package com.example.sping_portfolio.algorithms;

import lombok.Getter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;



@Getter  // this will enable standard Getters on attributes in Class in form "getName" where "name" is attribute
public class _Padovan {
    int size;
    String name;
    int hashID;
    Duration timeElapsed;
    ArrayList<Long> list;
    HashMap<Integer, Object> hash;

    /*
     Zero parameter constructor uses Telescoping technique to allow setting of the required value n
     @param: none
     */
    public _Padovan() {
        this( 20);
    }

    /*
     Construct the n fibonacci number
     @param: n number, the value is constrained to 92 because of overflow in a long
     */
    public _Padovan(int n) {
        this.size = n;
        this.list = new ArrayList<>();
        this.hashID = 0;
        this.hash = new HashMap<>();
        //initialize fibonacci and time algorithm
        Instant start = Instant.now();  // time capture -- start
        this.init();
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    /*
     Method is abstract as init() requires extender to define their own Fibonacci algorithm
     Method is protected as it is only authorized to someone who extends the class
     */
    protected void init(){
        this.name = "For in _Fib";
        long limit = this.size;
        // for loops are likely the most common iteration structure, all the looping facts are in one line
        for (long[] f = new long[]{0, 1}; limit-- > 0; f = new long[]{f[1], f[0] + f[1]})
            this.setData(f[0]);
    }

    /*
     Number is added to Fibonacci sequence, current state of "list" is added to hash for hashID "num"
     */
    public void setData(long num) {
        list.add(num);
        hash.put(this.hashID++, list.clone());
    }

    /*
     Custom Getter for timeElapsed in init process, timeElapsed.getNano() is part of Duration class
     */
    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }

    /*
     Custom Getter to return last element in Fibonacci sequence
     */
    public long getn() {
        return list.get(size - 1);
    }

    /*
     Custom Getter to return last Fibonacci sequence in HashMap
     */
    public Object getnSeq(int i) {
        return hash.get(i);
    }

}
