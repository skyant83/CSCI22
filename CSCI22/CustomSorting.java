package CSCI22;

import java.util.Scanner;

public class CustomSorting {
    private static boolean isAscending = true;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numOfInput = input.nextInt();
        int nums[] = new int[numOfInput];
        
        for (int i = 0; i < numOfInput; i++)
            nums[i] = input.nextInt();

        switch (input.nextInt()) {
            case -1:
                isAscending = false;
                break;
            case 1:
                isAscending = true;
                break;
        }

        Sorting(nums, numOfInput);
        for (int i = 0; i < numOfInput; i++) {
            System.err.println(nums[i]);
        }
    
        input.close();
    }

    static void Sorting(int arr[], int n) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            int temp = 0;
        
            for (int i = 1; i <= n - 2; i += 2) {
                if ((isAscending && arr[i] > arr[i + 1]) || (!isAscending && arr[i] < arr[i + 1])) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        
            for (int i = 0; i <= n - 2; i += 2) {
                if ((isAscending && arr[i] > arr[i + 1]) || (!isAscending && arr[i] < arr[i + 1])) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
