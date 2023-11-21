// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            UserAuthentication userAuth = new UserAuthentication();
            CheckingAccount checkingAccount = new CheckingAccount(0);
            SavingsAccount savingsAccount = new SavingsAccount(0);

            checkingAccount.deposit(1000);
            checkingAccount.withdraw(200);

             checkingAccount.convertToSavings(500, savingsAccount);

             System.out.println("Balance in savings account: " + savingsAccount.getBalance());
             System.out.println("Balance in checking account: " + checkingAccount.getBalance());


        while (true) {
                System.out.println("Menu:");
                System.out.println("1. Login");
                System.out.println("2. Create a new user");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password: ");
                    String password = scanner.next();
                    if (userAuth.authenticateUser(username, password)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;
                    case 2:
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.next();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.next();
                    userAuth.saveUserToFile(newUsername, newPassword);
                    System.out.println("User created successfully!");
                    break;
                    case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
            default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    }
                }
            }

