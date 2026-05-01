import java.util.*;

// generic class with two type parameters for username and password
class LoginSystem<U, P> {

    private U storedUsername;
    private P storedPassword;

    public LoginSystem(U username, P password) {
        this.storedUsername = username;
        this.storedPassword = password;
    }

    public boolean checkLogin(U enteredUser, P enteredPass) {
        return storedUsername.equals(enteredUser) && storedPassword.equals(enteredPass);
    }
}

public class Task3 {
    public static void main(String[] args) {

        String savedUsername = "admin123";
        String savedPassword = "pass@456";

        LoginSystem<String, String> login = new LoginSystem<>(savedUsername, savedPassword);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String inputUser = sc.nextLine();

        System.out.print("Enter password: ");
        String inputPass = sc.nextLine();

        boolean result = login.checkLogin(inputUser, inputPass);

        if (result) {
            System.out.println("Login successful! Welcome, " + inputUser + ".");
        } else {
            System.out.println("Invalid credentials. Terminating program.");
            System.exit(0);
        }

        sc.close();
    }
}