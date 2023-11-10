import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {

    private Map<String, String> userDatabase;
    private static final String FILE_PATH = "C:\\Users\\ANDRES-PC\\Documents\\ConvertWallet\\src\\users.txt";

    public UserAuthentication() {
        userDatabase = new HashMap<>();
        loadUsersFromFile(FILE_PATH);
    }

    private void loadUsersFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(":");
                userDatabase.put(userData[0], userData[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUserToFile(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(username + ":" + password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String username, String password) {
        String storedPassword = userDatabase.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuthentication userAuth = new UserAuthentication();

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
}

