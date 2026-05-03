package Java.Practice;

public class Revision {
    public static void main(String args[]) {
        Revision rev = new Revision();

        System.out.println(rev.reverseDigit(123));

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
