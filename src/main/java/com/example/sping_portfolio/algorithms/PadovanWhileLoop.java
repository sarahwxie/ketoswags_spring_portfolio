package com.example.sping_portfolio.algorithms;

public class PadovanWhileLoop extends PadovanBase{

    @Override
    public void calculatePadovan (int n) {
        initialize(n);
        if (n<3)
            return;

        int i = 3;
        while (i < n){
            sequence[i]=sequence[i-2]+sequence[i-3];
            i++;
        }
    }
}