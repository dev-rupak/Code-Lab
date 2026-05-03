package Java.Practice;

public class Revision {
    public static void main(String args[]) {
        Revision rev = new Revision();

        rev.hollowRhombus(5);

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
