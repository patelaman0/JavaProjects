import java.util.*;
public class libraryManagement {
    public static void main(String []args){

        Scanner sc = new Scanner (System.in);
        String showAll[][] = new String[100][2];
        boolean issuedBook [] = new boolean[100];

         int count = 0;

        while(true) {
            System.out.println("----Library Management---- \n" +
                    "1. Add Book \n " +
                    "2. Show All Books \n " +
                    "3. Search Book \n " +
                    "4. Issue Book \n " +
                    "5. Return Book \n " +
                    "6. Exit \n ");


            System.out.println("Enter your choice :");
            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Enter book title: ");
                    String bookTitle = sc.nextLine();

                    System.out.println("Enter Author Name : ");
                    String authorName = sc.nextLine();

                    showAll[count][0] = bookTitle;
                    showAll[count][1] = authorName;
                    count++;


                    System.out.println("BOOK ADDED SUCCESSFULLY");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("There is no book");
                    } else {
                        for (int i = 0; i < count; i++) {
                            System.out.println("Title :  " + showAll[i][0] + " \n"  + "Author: " + showAll[i][1]);
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter Book Name:");
                    String searchBook = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < count ; i++){
                        if (searchBook.equalsIgnoreCase( showAll[i][0])){
                            System.out.println("Title :   " + showAll[i][0] + "\n "  + "Author: " + showAll[i][1]);
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Book Not Found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Book Name");
                    String issuingBook = sc.nextLine();
                    boolean issued = false;

                    for (int i = 0 ; i < count ; i++){
                        if (issuingBook.equalsIgnoreCase( showAll[i][0])){
                        if (!issuedBook[i]) {
                            issuedBook[i] = true ;
                            System.out.println("Book issued Succesfully");
                        }else {
                            System.out.println("Book has issued");
                        }

                        }
                    }


                    break;

                case 5:
                    System.out.println("Enter Book name :");
                    String returnBook = sc.nextLine();
                    boolean rbook = false;

                    for(int i = 0 ; i < count ; i++){
                        if (returnBook.equalsIgnoreCase(showAll[i][0])){
                            rbook = true;

                            if (issuedBook[i]) {
                                issuedBook[i] = false;
                                System.out.println("Book returned successfully!");
                            } else {
                                System.out.println("This book was not issued.");
                            }}
                    }
                    break;


                case 6:
                    System.out.println("Exiting the System.....");
                    return;



                default:
                    System.out.println("Invalid Choice");


            }
        }
    }
}
