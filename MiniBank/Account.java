package MiniBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;


public class Account {
    Random rand = new Random();
    String HolderName;
    int HolderAccountNumber;
    String HolderPassword;
    String cardNumber = "123-456-789";
    int cardPin = 1234;
    int cardLimit = 500;
    List<String> TransactionHistory = new ArrayList<>();

    public  void createAccount(Scanner sc){
        try {
            Connection conn = Connections.functionConnection();
            Statement smt = conn.createStatement();
            System.out.println("\nCreate a Account \n ");
            System.out.print("Enter a Name: ");
            this.HolderName = sc.nextLine();
            System.out.print("Generating  a Account Number: ");
            this.HolderAccountNumber = 1000 + rand.nextInt(90000);
            System.out.println(HolderName + " your Account Number is : "+ HolderAccountNumber);
            System.out.print("Enter a Password: ");
            this.HolderPassword = sc.nextLine();

            System.out.println("Account is Created " + HolderName +". \n");

            String insertData = "INSERT INTO BankAccount (NAME ,ACCOUNTNUMBER,PASSWORD) Values ('"
                    + HolderName +"',"
                    + HolderAccountNumber + ",'"
                    + HolderPassword + "')";

            smt.executeUpdate(insertData);

        }catch(Exception e){
            e.printStackTrace();

        }


    }

    public void login(Scanner sc){
        System.out.println("\nLogin in Account \n ");
        System.out.print("Enter a Account Number: ");
        int checkAccountNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter a Password: ");
        String checkPassword = sc.nextLine();

        try{
            Connection conn = Connections.functionConnection();
            Statement smt = conn.createStatement();

            String checkData = "SELECT NAME,PASSWORD,BALANCE FROM BankAccount WHERE ACCOUNTNUMBER = "+ checkAccountNumber;
            ResultSet rs =  smt.executeQuery(checkData);

            if(rs.next()){
                String dbPASSWORD = rs.getNString("PASSWORD");
                String dbName = rs.getString("NAME");
                Double dbBalance = rs.getDouble("Balance");
                if(dbPASSWORD.equals(checkPassword)){
                    System.out.println("Login Successfully \n \n " +
                            "Welcome " + dbName +"\n ");

                    while(true){
                        System.out.println("Menu \n"+
                                "1. Check Balance \n" +
                                "2. Withdraw Amount \n" +
                                "3. Deposit Amount \n" +
                                "4. Transaction History \n" +
                                "5. Account Summary \n" +
                                "6. Credit Card Details \n" +
                                "7. Exit \n");

                        System.out.print("Enter a number: ");
                        int check = sc.nextInt();

                        switch(check){
                            case 1:
                                System.out.println("Total Balance is : " + dbBalance +"\n");
                                break;
                            case 2:
                                System.out.print("Enter a Amount to Withdraw: ");
                                double withdrawAmount = sc.nextInt();
                                if(withdrawAmount <= dbBalance){
                                    String totalAmount = " UPDATE BankAccount SET BALANCE = BALANCE - " + withdrawAmount +
                                            " WHERE ACCOUNTNUMBER = "+ checkAccountNumber;
                                    smt.executeUpdate(totalAmount);
                                    System.out.println(withdrawAmount + " withdraw successfully \n");
                                    dbBalance -= withdrawAmount;
                                    TransactionHistory.add("Withdraw :" + withdrawAmount);
                                }else {
                                    System.out.println("Not enough Money \n");
                                }

                                break;
                            case 3:
                                System.out.print("Enter a Amount to Deposit: ");
                                double depositAmount = sc.nextInt();

                                if (depositAmount < 0 ){
                                    System.out.println("Invalid Amount \n" );
                                }else{
                                    String totalAmount = " UPDATE BankAccount SET BALANCE = BALANCE + " + depositAmount +
                                            " WHERE ACCOUNTNUMBER = "+ checkAccountNumber;
                                    smt.executeUpdate(totalAmount);
                                    dbBalance += depositAmount;

                                    System.out.println(depositAmount + " Successfully Deposited \n");
                                    TransactionHistory.add("Deposited: " + depositAmount);
                                }


                                break;

                            case 4:
                                System.out.println("Transaction History \n");
                                if(TransactionHistory.isEmpty()){
                                    System.out.println("No transaction yet \n");
                                }else{
                                    for(String entry : TransactionHistory){
                                        System.out.println(entry +"\n");
                                    }
                                }

                                break;

                            case 5:
                                System.out.println("Account Summary \n \n" +
                                        "Name: " + dbName + "\n" +
                                        "Account Number: " + checkAccountNumber + "\n" +
                                        "Total Balance is: "+ dbBalance +"\n");
                                break;

                            case 6:
                                cardDetails();
                                break;


                            case 7:
                                System.out.println(dbName + " has successfully Logout \n \n");
                                return;

                            default:
                                System.out.println("Invalid Number");
                        }


                    }
                }else{
                    System.out.println("Password is Invalid");
                }
            }else{
                System.out.println("Sorry , Account Number not Found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }
    public void cardDetails(){
        System.out.println("hello");
    }
}
class CreditCard extends Account {

    public void cardDetails(){
        System.out.println("Credit Card Details :\n"+
                "\nName: "+ HolderName +
                " \nCard Number: " + cardNumber +
                " \nDefault Atm Card Password: " + cardPin +
                " \nCard Limit: " + cardLimit+ "\n");

    }

}


