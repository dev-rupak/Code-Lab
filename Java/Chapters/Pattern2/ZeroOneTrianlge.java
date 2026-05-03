package Chapters.Pattern2;

public class ZeroOneTrianlge {

  public static void main(String args[]) {
    int n = 5, printElement = 1;

    for (int i = 1; i <= n; i++) {
      printElement = i % 2 == 0 ? 0 : 1;
      for (int j = 1; j <= i; j++) {
        System.out.print(printElement + " ");
        printElement = printElement == 1 ? 0 : 1;
      }
      System.out.println();
    }
  }
}
