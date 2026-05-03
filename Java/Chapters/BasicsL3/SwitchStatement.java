package Chapters.BasicsL3;

public class SwitchStatement {

  public static void main(String[] args) {
    int num = 4;
    switch (num) {
      case 1:
        System.out.println("Samosa");
        break;
      case 2:
        System.out.println("Burger");
        break;
      case 3:
        System.out.println("Momos");
        break;
      default:
        System.out.println("I was dreaming");
    }
  }
}
