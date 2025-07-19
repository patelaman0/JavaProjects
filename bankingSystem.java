import java.util.*;
public class bankingSystem {
    public static void main (String []args){
        Scanner sc = new Scanner (System.in);

        int accountNumber [] = new int [100];
        String holderName [] = new String[100];
        float amount [] = new float [100];
        int count = 0;

        while(true){
            System.out.println("----- Banking System ----- \n" +
                    "1. Create Account \n" +
                    "2. View All Account \n" +
                    "3. Deposit \n" +
                    "4. Withdraw \n" +
                    "5. Search Account \n" +
                    "6. Exit");

            System.out.println("Enter your choice :");
            int choice = sc.nextInt();


            switch(choice){

                case 1:
                    System.out.println("Enter Account Number :");
                    int accNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Account Holder Name:");
                    String accName = sc.nextLine();
                    System.out.println("Enter Inital Balance");
                    int accBalance = sc.nextInt();
                    System.out.println("\n");

                    accountNumber[count]= accNumber;
                    holderName[count] = accName;
                    amount[count]= accBalance;

                    count++;
                    System.out.println("Account Successfully Created \n \n ");

                    break;

                case 2:
                    System.out.println("Showing all Account \n");
                    if (count == 0 ){
                        System.out.println("Sorry , no account was added \n " +
                                "Please add a Account");
                    }
                    for(int i = 0 ; i < count;i++){
                        System.out.println("Account Number :" + accountNumber[i] + " \n"+ "Account Holder Name : " + holderName[i] +
                                " \n" +"Total Amount : " + amount[i] + " \n \n");

                    }
                    break;

                case 3:
                    System.out.println("Enter Account Number");
                    int depositaccNumber = sc.nextInt();
                    boolean found = false;

                    for(int i =0 ; i <count ;i++){
                        if(depositaccNumber == accountNumber[i]){
                            System.out.println("Enter amount to add on this account ");
                            float depositAmount = sc.nextInt();

                            amount[i] += depositAmount;

                            System.out.println(depositAmount +" Successfully you have credited your amount ");

                            found = true;

                        }
                    }
                    if(!found){
                        System.out.println("Account Number not found \n " +
                                "Please Create a new bank account ");
                    }

                    break;

                case 4:
                    System.out.println("Enter Account Number");
                    int withdrawaccNumber = sc.nextInt();
                    boolean find = false;

                    for(int i = 0 ; i< count;i++){
                        if(withdrawaccNumber == accountNumber[i]){
                            System.out.println("Enter a withdraw Amount");
                            int withdrawAmount = sc.nextInt();
                          float  finalAmount = amount[i] - withdrawAmount;

                            if( finalAmount <= -1){
                                System.out.println("Insufficient balance");
                            }else{
                                System.out.println(withdrawAmount + " amount was debited in your account");
                            }
                            amount[i] = finalAmount;

                                    find = true;

                        }
                    }
                    if (!find){
                        System.out.println("Account Number not found \n " +
                                "Please Create a new bank account ");
                    }

                    break;

                case 5:
                    System.out.println("Enter Account Number");
                    int searchaccNumber = sc.nextInt();
                    boolean find1 = false;

                    for(int i =0 ; i < count ; i++){
                        if (searchaccNumber == accountNumber[i]){
                            System.out.println(searchaccNumber + " Yes, we have this account Number\n" +
                                    "Details of user \n" +
                                    "Account number : " + accountNumber[i] + "\n" +
                                    "Account holder Name :" + holderName[i] + "\n" +
                                    "Total Amount : " + amount[i] +"\n");
                            find1 = true;
                        }

                    }

                    if (!find1){
                        System.out.println("Account Number not found \n " +
                                "Please Create a new bank account ");
                    }

                    break;



                case 6:
                    System.out.println("Exiting from Banking System \n" +
                            "THANK YOU.......");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        }
    }
}
