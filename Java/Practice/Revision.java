package Java.Practice;

public class Revision {
    public static void main(String args[]) {
        Revision rev = new Revision();
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + "\t" + rev.isPrime(i));
        }
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
