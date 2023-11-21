import java.util.Scanner;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {

    private Map<String, String> userDatabase;
    private BankAccount BankAccount;

    public Map<String, String> getUserDatabase() {
        return userDatabase;
    }

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


}

