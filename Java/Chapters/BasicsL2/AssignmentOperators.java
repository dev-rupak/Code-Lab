package Chapters.BasicsL2;

public class AssignmentOperators {

  public static void main(String args[]) {
    int a = 3, b = 5, temp = 0;
    temp = a; // 3
    System.out.println(temp);

    temp += b; // 8
    System.out.println(temp);

    temp -= a; // 5
    System.out.println(temp);

    temp *= b; // 25
    System.out.println(temp);

    temp /= a; // 8
    System.out.println(temp);

    temp %= b; // 2
    System.out.println(temp);
  }
}
