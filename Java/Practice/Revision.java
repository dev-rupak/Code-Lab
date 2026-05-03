package Java.Practice;

public class Revision {
    public static void main(String args[]) {
        Revision rev = new Revision();

        System.out.println(rev.binary2Decimal(101));

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
