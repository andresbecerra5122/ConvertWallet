class CheckingAccount extends BankAccount {
    public CheckingAccount(double balance) {
        super(balance);
    }

    public void convertToSavings(double amount, SavingsAccount savingsAccount) {
        if (amount <= balance) {
            balance -= amount;
            savingsAccount.deposit(amount);
            System.out.println("Conversion to savings account successful.");
        } else {
            System.out.println("Insufficient funds for conversion.");
        }
    }
}
