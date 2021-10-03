package com.example.sping_portfolio.controllers;

import java.util.Calendar;

interface IBinarySearch{
//    int binarySearch(int arr[], int l, int r, int x);
    int binarySearch(int arr[], int x);
}

abstract class BinarySearch implements IBinarySearch {
    public abstract int binarySearch(int arr[], int x);
    void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class RecursiveBinarySearch extends BinarySearch {
    @Override
    public int binarySearch(int[] arr, int x) {
        return binarySearch(arr, 0, arr.length, x);
    }
    // Returns index of x if it is present
    int binarySearch(int arr[], int l, int r, int x)
    {
        sleep();
        if (r >= l && l<arr.length) {

            int mid = l + (r - l) / 2;

            // If the element is present
            // at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present in right
            // subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    // Driver method to test above
    public static void main(String args[])
    {
    int length = 10000;
    int arr[] = new int[length];
    for (int i=0; i<length; i++){
        arr[i] = i;
    }

    int x = 750;
        IBinarySearch ob = new RecursiveBinarySearch();
        doSearch(ob, arr, x);
        ob = new ForSearch();
        doSearch(ob, arr, x);
    }

    private static int doSearch(IBinarySearch ob, int arr[], int x) {
        long start = Calendar.getInstance().getTimeInMillis();
        int result = ob.binarySearch(arr, x);
        long end = Calendar.getInstance().getTimeInMillis();
        long totalTimeinMS = end - start;
        if (result == -1)
            System.out.println("Element not present, time: " + totalTimeinMS);
        else
            System.out.println("Element found at index " + result + " time: " + totalTimeinMS);
        return result;
    }

    static class ForSearch extends BinarySearch{
        @Override
        // Returns index of x if it is present
        public int binarySearch(int arr[], int x)
        {
            sleep();
          for (int i=0; i<arr.length; i++){
              if (arr[i] == x){
                  return i;
              }
          }
          return -1;
        }

    }
}