class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit made. Current balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal made. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}