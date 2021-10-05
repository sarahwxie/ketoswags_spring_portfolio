package com.example.sping_portfolio.algorithms;

public class PadovanForLoop extends PadovanBase{

    @Override
    public int calculatePadovan (int n) {
        if (n < 3)
            return 1;

        int[] arr = new int[n];
        arr[0] = arr[1] = arr[2] = 1;
        for (int i = 3; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
        return arr[n - 1];
    }
}
