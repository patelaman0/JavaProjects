package MiniBank;
import java.util.Scanner;
public class MiniBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CreditCard dc = new CreditCard();
        Connections.functionConnection();


        System.out.println("----Welcome to Mini Bank---- \n \n");

        while(true){
            System.out.println("Main Menu  \n"+
                    "1. Create Account \n" +
                    "2. Login Account \n" +
                    "3. Exit \n");
            System.out.print("Enter a number: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    dc.createAccount(sc);
                    break;
                case 2:
                    dc.login(sc);
                    break;
                case 3:

                System.out.println("Thanks for using Mini Bank");
                    return;


                default:
                    System.out.println("Invalid Number");

            }
        }

    }
}

