import java.util.Scanner;

public class Main {

    // Main method
    public static void main(String[ ] args) {
//        myStaticMethod(); // Call the static method
        // myPublicMethod(); This would output an error
        String x;
        int chk;
        Second myObj = new Second("");// Create an object of Main
        Scanner inpt = new Scanner(System.in);
        Thread thread1 = new Fourth();

        System.out.print("Enter username: ");
        String username = inpt.nextLine();

        System.out.print("Enter passwords: ");
        String passwords = inpt.nextLine();

        thread1.start();
        System.out.println("Waiting...");
        while(thread1.isAlive()); // For waiting thread

//        System.out.println(username + passwords + " " + username.length() + " " + passwords.length());

        myObj.setValue(username, passwords);

        chk = myObj.checkid();
        String result = (chk == 1)? "OK" : "NG";
        System.out.println(result);
    }
}