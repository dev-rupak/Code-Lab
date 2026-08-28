package Java.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class Revision {
    public static void main(String args[]) {
        Revision rev = new Revision();
        Scanner sc = new Scanner(System.in);

        int sudoku[][] = {
                { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
                { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
                { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
                { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
                { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
                { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
                { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
                { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        };
        rev.sudukoSolver(sudoku, 0, 0);

        sc.close();
    }

    // backtracking

    // suduko
    boolean sudukoSolver(int suduko[][], int row, int col) {
        if (row == 9 && col == 0) {
            System.out.println((Arrays.deepToString(suduko)).replace("], [", "],\n ["));
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }
        if (suduko[row][col] != 0) {
            return sudukoSolver(suduko, nextRow, nextCol);
        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(suduko, row, col, digit)) {
                suduko[row][col] = digit;
                if (sudukoSolver(suduko, nextRow, nextCol)) {
                    return true;
                }
                suduko[row][col] = 0;
            }
        }

        return false;
    }

    boolean isSafe(int[][] suduko, int row, int col, int digit) {
        for (int i = 0; i < 9; i++) {
            if (suduko[row][i] == digit) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (suduko[i][col] == digit) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (suduko[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    // gridways
    int gridWays(int startrow, int startcol, int endrow, int endcol) {
        if (startrow == endrow - 1 && startcol == endcol - 1) {
            return 1;
        }
        if (startrow == endrow || startcol == endcol) {
            return 0;
        }

        return gridWays(startrow + 1, startcol, endrow, endcol) + gridWays(startrow, startcol + 1, endrow, endcol);
    }

    // nQueen
    void nQueen(char board[][], int row) {
        if (row == board.length) {
            System.out.println("......Chess Board......");
            System.out.println(Arrays.deepToString(board).replace("], [", "],\n ["));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                nQueen(board, row + 1);
                board[row][col] = 'X';
            }
        }
    }

    boolean isSafe(char board[][], int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    // permutation
    void permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutation(newStr, ans + curr);
        }
    }

    // find subsets
    void subset(String str, String ans, int idx) {
        if (idx == str.length()) {
            System.out.println(ans);
            return;
        }

        subset(str, ans + str.charAt(idx), idx + 1);
        subset(str, ans, idx + 1);
    }

    // backtracking on arrays
    void btArray(int arr[], int idx, int num) {
        if (idx == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[idx] = num;
        btArray(arr, idx + 1, num + 1);
        arr[idx] -= 2;
    }

    // divide & conquer
    int search(int arr[], int target, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        int mid = si + (ei - si) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {
            if (arr[si] <= target && target <= arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                return search(arr, target, mid + 1, ei);
            }
        } else {
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei);
            } else {
                return search(arr, target, si, mid - 1);
            }
        }
    }

    void quickSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1);
        quickSort(arr, pIdx + 1, ei);
    }

    int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        i++;
        arr[ei] = arr[i];
        arr[i] = pivot;

        return i;
    }

    void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int leftId = si;
        int rightId = mid + 1;
        int tempId = 0;

        while (leftId <= mid && rightId <= ei) {
            if (arr[leftId] < arr[rightId]) {
                temp[tempId] = arr[leftId];
                tempId++;
                leftId++;
            } else {
                temp[tempId] = arr[rightId];
                tempId++;
                rightId++;
            }
        }

        while (leftId <= mid) {
            temp[tempId] = arr[leftId];
            tempId++;
            leftId++;
        }

        while (rightId <= ei) {
            temp[tempId] = arr[rightId];
            tempId++;
            rightId++;
        }

        for (int i = 0, j = si; i < temp.length; i++, j++) {
            arr[j] = temp[i];
        }
    }

    void printBinString(int num, int lastdigit, String sb) {
        if (num == 0) {
            System.out.println(sb);
            return;
        }
        printBinString(num - 1, 0, sb + '0');
        if (lastdigit == 0) {
            printBinString(num - 1, 1, sb + '1');
        }
    }

    int friendsPair(int friend) {
        if (friend == 1 || friend == 2) {
            return friend;
        }
        int single = friendsPair(friend - 1);
        int pair = (friend - 1) * friendsPair(friend - 2);

        return single + pair;
    }

    void removeDuplicate(String str, int idx, StringBuilder sb, boolean map[]) {
        if (idx == str.length()) {
            System.out.println(sb.toString());
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicate(str, idx + 1, sb, map);
        } else {
            map[currChar - 'a'] = true;
            removeDuplicate(str, idx + 1, sb.append(currChar), map);
        }
    }

    int tilingWays(int num) {
        // 2 * num - area
        // 2 * 1 - tile area
        if (num == 0 || num == 1) {
            return 1;
        }
        int vertical = tilingWays(num - 1);
        int horizontal = tilingWays(num - 2);

        return vertical + horizontal;
    }

    int optimizedPower(int num, int exp) {
        if (exp == 0) {
            return 1;
        }
        int halfpower = optimizedPower(num, exp / 2);
        if (exp % 2 == 0) {
            return halfpower * halfpower;
        } else {
            return num * halfpower * halfpower;
        }
    }

    int power(int num, int exp) {
        if (exp == 0) {
            return 1;
        }
        return num * power(num, exp - 1);
    }

    int lastOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        } else {
            return isFound;
        }
    }

    int firstOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        } else {
            return firstOccurance(arr, key, i + 1);
        }
    }

    boolean arraySortedOrNot(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return arraySortedOrNot(arr, i + 1);
    }

    int fibbonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibbonacci(num - 1) + fibbonacci(num - 2);
    }

    int sumOfNnum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sumOfNnum(num - 1);
    }

    int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    void printIncreasingNumOrder(int num) {
        if (num == -1) {
            return;
        }

        printIncreasingNumOrder(num - 1);
        System.out.print(num + "\t");
    }

    void printDecreasingNumOrder(int num) {
        if (num == -1) {
            return;
        }

        System.out.print(num + "\t");
        printDecreasingNumOrder(num - 1);
    }

    int fastExponent(int num, int exp) {
        int ans = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans *= num;
            }
            num *= num;
            exp = exp >> 1;
        }
        return ans;
    }

    void countBitInNum(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }
        System.out.println(count);
    }

    boolean powerOf2OrNot(int num) {
        if ((num & (num - 1)) == 0) {
            return true;
        } else {
            return false;
        }
    }

    void clearBitRange(int num, int i, int j) {
        int leftmask = ((~0) << (j + 1));
        int rightmask = ((1 << i) - 1);
        int mask = leftmask | rightmask;
        System.out.println(num & mask);
    }

    void upadteTheiTHbit(int num, int i, int val) {
        if (val == 0 || val == 1) {
            System.out.println((num & (~(1 << i))) | (val << i));
        }
    }

    void clearTheiTHbit(int num, int i) {
        System.out.println(num & (~(1 << i)));
    }

    void setTheiTHbit(int num, int i) {
        System.out.println(num | (1 << i));
    }

    void getTheiTHbit(int num, int i) {
        if ((num & (1 << i)) == 0) {
            System.out.println("ith bit is 0");
        } else {
            System.out.println("ith bit is 1");
        }
    }

    boolean oddOrNot(int num) {
        int bitmask = 1;
        if ((num & bitmask) == 1) {
            return true;
        } else {
            return false;
        }
    }

    void shortestPathString(String str) {
        if (str == null || str.length() == 0) {
            System.out.println("Shortest path = 0.0");
            return;
        }

        String upperStr = str.toUpperCase();

        int x = 0, y = 0;
        for (int i = 0; i < upperStr.length(); i++) {
            char direction = upperStr.charAt(i);
            if (direction == 'W') {
                x--;
            } else if (direction == 'E') {
                x++;
            } else if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            }
        }
        float path = (float) Math.sqrt(x * x + y * y);
        System.out.println("Shortest path = " + path);
    }

    boolean palindromeString(String str) {
        if (str == null) {
            return false;
        }
        int letter = str.length() - 1;

        for (int i = 0; i <= letter / 2; i++) {
            if (str.charAt(i) != str.charAt(letter - i)) {
                return false;
            }
        }
        return true;
    }

    void searchInSortedMatrix(int mat[][], int key) {
        int startRow = 0;
        int endRow = mat.length - 1;
        int startCol = 0;
        int endCol = mat[0].length - 1;

        boolean found = false;

        while (endCol >= startCol && startRow <= endRow) {
            if (key == mat[startRow][endCol]) {
                System.out.println("Key found at index (" + startRow + ", " + endCol + ").");
                found = true;
                break;
            } else if (key < mat[startRow][endCol]) {
                endCol--;
            } else if (key > mat[startRow][endCol]) {
                startRow++;
            }
        }

        if (!found) {
            System.out.println("key not found");
        }
    }

    void diagonalSum(int mat[][]) {
        int sum = 0;
        if (mat.length != mat[0].length) {
            System.out.println("Diagonal sum not possible.");
        } else {
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][i];
                if (i != mat.length - i - 1) {
                    sum += mat[i][mat.length - i - 1];
                }
            }
        }
        System.out.println("Diagonal Sum = " + sum);
    }

    void spiralMatrix(int matrix[][]) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int col = startCol; col <= endCol; col++) {
                System.out.print(matrix[startRow][col] + "\t");
            }
            // right
            for (int row = startRow + 1; row <= endRow; row++) {
                System.out.print(matrix[row][endCol] + "\t");
            }
            // bottom
            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) {
                    break;
                } else {
                    System.out.print(matrix[endRow][col] + "\t");
                }
            }
            // left
            for (int row = endRow - 1; row >= startRow + 1; row--) {
                if (startCol == endCol) {
                    break;
                } else {
                    System.out.print(matrix[row][startCol] + "\t");
                }
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
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
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
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
