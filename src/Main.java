import controller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        home();
    }

    private static void home() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Hello!\tWelcome to the Hospital Page.");
        while (true) {
            System.out.println("What can I do For U? (register? / showTables?)");
            String input=sc.nextLine();
            switch (input){
                case "register":
                    Controller.register();
                    break;
                case "showTables":
                    Controller.showTables();
                    break;
            }

        }
    }
}
