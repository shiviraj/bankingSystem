import java.util.Scanner;
import banking.Banking;

public class Main{
  private Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    Main action = new Main();
    String name = action.takeName();
    Banking banking = new Banking(name);
    char option = 'a';
    while(option != 'E'){
      option = action.takeOption();
      String result = action.performAction(option, banking);
      System.out.println(result);
    }
  }

  public String takeName() {
    System.out.println("Enter your name: ");
    String name = this.sc.nextLine();
    return name;
  }

  public char takeOption() {
    System.out.println("\nEnter an option to perform action: ");
    System.out.println("A: Check Balance");
    System.out.println("B: Deposit Money");
    System.out.println("C: Withdraw Money");
    System.out.println("D: Check last Transaction");
    System.out.println("E: Exit");
    return this.sc.next().charAt(0);
  }

  public String performAction(char option, Banking banking) {
    int money = 0;
    switch (option) {
      case 'A':
        return Integer.toString(banking.getBalance());
      case 'B':
        System.out.println("Enter money to Deposit");
        money = this.sc.nextInt();
        return banking.depositMoney(money);
      case 'C':
        System.out.println("Enter money to Withdraw");
        money = this.sc.nextInt();
        return banking.withdrawMoney(money);
      case 'D':
        return banking.lastTransaction();
      case 'E':
        return "Exit";
      default:
        return "Invalid option";
    }
  }
}