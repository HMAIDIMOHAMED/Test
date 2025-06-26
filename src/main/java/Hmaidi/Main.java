package Hmaidi;

public class Main {
    public static void main(String[] args) {

        Account account = new Account();
        account.deposit(1000, "24-06-2025");
        account.deposit(2000, "25-06-2025");
        account.withdraw(500, "26-06-2025");

        account.printStatement();
    }
}