package com.example.sping_portfolio.algorithms;



public class Padovan {

    public int calculateWithForLoop(int n) {
        if (n<3)
            return 1;

        int [] arr = new int[n];
        arr[0]=arr[1]=arr[2]=1;
        for (int i = 3; i < n; i++) {
            arr[i]=arr[i-2]+arr[i-3];
        }
        return arr[n-1];

    }

    public int calculateWithWhileLoop(int n) {
        if (n<3)
            return 1;

        int [] arr = new int[n];
        arr[0]=arr[1]=arr[2]=1;

        int i = 3;
        while (i < n){
            arr[i]=arr[i-2]+arr[i-3];
            i++;
        }
        return arr[n-1];
    }
}
