package com.example.sping_portfolio.algorithms;

public abstract class PadovanBase {
    protected int[] sequence = null;
    protected void initialize (int n) {
        sequence = new int[n];
        if(n > 0)
            sequence[0] = 1;
        if(n > 1)
            sequence[1] = 1;
        if(n > 2)
            sequence[2] = 1;
    }
    public abstract void calculatePadovan (int n);
    public int getResults(){
        if (sequence == null)
            return 0;
        return sequence[sequence.length-1];
    }
}
