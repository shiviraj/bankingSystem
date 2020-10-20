package banking;

public class Banking{
  private int id;
  private String name;
  private int ammount;
  private int lastTransaction;
  private String lastTransactionType = "No Transactions happened.";

  public Banking(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Banking ");
    sb.append("{\"name\":\"" +  this.name + "\", ");
    sb.append("\"ammount\":" +  this.ammount + "}");
    return new String(sb);
  }

  public String depositMoney(int money){
    this.ammount += money;
    lastTransaction = money;
    lastTransactionType = "Deposited ";
    return this.lastTransaction();
  }

  public String withdrawMoney(int money){
    if( money > this.ammount) {
      return "You don't have sufficient ammount.";
    }
    this.ammount -= money;
    lastTransaction = money;
    lastTransactionType = "Withdraw ";
    return this.lastTransaction();
  }

  public int getBalance(){
    return this.ammount;
  }

  public String lastTransaction(){
    return this.lastTransactionType + this.lastTransaction;
  }

}