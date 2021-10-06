package com.example.sping_portfolio.algorithms;

public class PadovanForLoop extends PadovanBase{

    @Override
    public void calculatePadovan (int n) {
        initialize(n);
        if (n<3)
            return;

        for (int i = 3; i < n; i++) {
            sequence[i] = sequence[i - 2] + sequence[i - 3];
        }
    }
}
