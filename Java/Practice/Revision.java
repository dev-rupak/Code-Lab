package Java.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Revision {
    public static void main(String args[]) {
        Revision rev = new Revision();
        Scanner sc = new Scanner(System.in);

        System.out.printf("How much number you want to enter: ");
        int arrLength = sc.nextInt();
        int arr[] = new int[arrLength];
        System.out.printf("Enter %d number : ", arr.length);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        rev.insertionSort(arr);
        System.out.println("after bubble sort : " + Arrays.toString(arr));

        sc.close();
    }

    void countingSort(int arr[]) {
        int largest = largestInArray(arr);
        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                count[i]--;
                j++;
            }
        }
    }

    // Basic Sorting Algoritham
    void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] >= curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int small = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[small] > arr[j]) {
                    small = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[small];
            arr[small] = tmp;
        }
    }

    void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    int profit(int price[]) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int i = 0; i < price.length; i++) {
            if (buyPrice > price[i]) {
                buyPrice = price[i];
            } else {
                maxProfit = Math.max(maxProfit, price[i] - buyPrice);
            }
        }
        return maxProfit;
    }

    int trappedRainwater(int height[]) {
        int num = height.length;
        int leftbound[] = new int[num];
        int rightbound[] = new int[num];
        leftbound[0] = height[0];
        rightbound[num - 1] = height[num - 1];
        for (int i = 1; i < num; i++) {
            leftbound[i] = Math.max(leftbound[i - 1], height[i]);
        }
        for (int i = num - 2; i >= 0; i--) {
            rightbound[i] = Math.max(rightbound[i + 1], height[i]);
        }
        int trappedWater = 0;
        for (int i = 0; i < num; i++) {
            int waterLevel = Math.min(rightbound[i], leftbound[i]);
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }

    void kadenAlgo(int arr[]) {
        // TC = O(n), SC = O(1) - only maximum

        int max = Integer.MIN_VALUE;
        int cs = 0;
        for (int i : arr) {
            cs += i;
            if (cs < 0) {
                cs = 0;
            } else {
                max = Math.max(max, cs);
            }
        }
        System.out.println("max subarray sum : " + max);
    }

    void prefixLogicSubarraySum(int arr[]) {
        // TC = O(n2), SC = O(1)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum < min) {
                    min = sum;
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("min subarray sum : " + min);
        System.out.println("max subarray sum : " + max);
    }

    void prefixSumArray(int arr[]) {
        // TC = O(n2), SC = O(n)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < prefix.length; i++) {
            int sum = 0;
            for (int j = i; j < prefix.length; j++) {
                sum = i == 0 ? prefix[j] : prefix[j] - prefix[i - 1];
                if (sum < min) {
                    min = sum;
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("min subarray sum : " + min);
        System.out.println("max subarray sum : " + max);
    }

    void printSubArraySum(int arr[]) {
        // TC = O(n3), SC = O(1)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum < min) {
                    min = sum;
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("min subarray sum : " + min);
        System.out.println("max subarray sum : " + max);
    }

    void printSubArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("(");
                for (int k = i; k <= j; k++) {
                    if (j == i || k == j) {
                        System.out.print(arr[k]);
                    } else {
                        System.out.print(arr[k] + ", ");
                    }
                }
                System.out.print(")\t");
            }
            System.out.println();
        }
    }

    void pairArrayPrint(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return;
            }
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + ", " + arr[j] + "), ");
            }
            System.out.println();
        }
    }

    void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    int binarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int largestInArray(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    int linearSearch(int arr[], int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    void hollowRhombus(int num) {
        for (int row = num; row >= 1; row--) {
            for (int col = 1; col < row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= num; col++) {
                if (row == num || row == 1 || col == 1 || col == num) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    void solidRhombus(int num) {
        for (int row = num; row >= 1; row--) {
            for (int col = 1; col < row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= num; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void butterflyPattern(int num) {
        for (int row = 1; row <= num / 2; row++) {
            for (int col = 1; col <= num; col++) {
                if (col <= row || col > (num - row)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int row = num / 2; row < num; row++) {
            for (int col = 1; col <= num; col++) {
                if (col <= (num - row) || col > (num - (num - row))) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    void zeroOneTriangle(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= row; col++) {
                if ((row + col) % 2 == 0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    void floydTriangle(int num) {
        int count = 1;
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(count++);
            }
            System.out.println();
        }
    }

    void invertedHalfPyramidNumber(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= num; col++) {
                if (col <= (num - row + 1)) {
                    System.out.print(col);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    void invertedRotatedHalfPyramid(int num) {
        for (int row = 0; row < num; row++) {
            for (int col = 0; col < num; col++) {
                if (col < (num - 1 - row)) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    void hollowRectanglePattern(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    int reverseDigit(int num) {
        int revNum = 0;
        while (num > 0) {
            int lastdigit = num % 10;
            revNum = (int) (revNum * 10) + lastdigit;
            num /= 10;
        }
        return revNum;
    }

    int decimal2Binary(int dec) {
        int bin = 0, pow = 0;
        while (dec > 0) {
            int remainder = dec % 2;
            bin = bin + (int) (remainder * Math.pow(10, pow));
            dec /= 2;
            pow++;
        }
        return bin;
    }

    int binary2Decimal(int bin) {
        int decimal = 0, pow = 0;
        while (bin > 0) {
            int lastdigit = bin % 10;
            decimal = decimal + (int) (lastdigit * Math.pow(2, pow));
            bin /= 10;
            pow++;
        }
        return decimal;
    }

    boolean isPrime(int num) {
        if (num < 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
