package Chapters.BasicsL3;

public class TernaryOperator {

  public static void main(String[] args) {
    int num = 4;

    String type = ((num % 2) == 0 ? "Even" : "Odd");
    System.out.println(type);
  }
}
