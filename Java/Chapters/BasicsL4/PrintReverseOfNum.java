package Chapters.BasicsL4;

public class PrintReverseOfNum {

  public static void main(String args[]) {
    int n = 10879;

    while (n != 0) {
      System.out.print(n % 10);
      n /= 10;
    }
  }
}
