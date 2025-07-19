import java.sql.SQLOutput;
import java.util.*;
import java.time.*;
public class votingEligibilityChecker {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("Welcome to \"Voting Machine\"");
        System.out.println("Enter Your Name");
        String name = a.nextLine();

        System.out.println("Enter your Age");
        int age  = a.nextInt();

        int currentYear = Year.now().getValue();


        if (age >= 18){
            System.out.format("%s you are eligible for vote",name);

        }
        else{
           int  minorYear =  18 - age;
           int eligibleYear = currentYear + minorYear ;
            System.out.format("%s you are not Eligible for vote." +
                    " \n Please wait for %d years.",name ,minorYear);
            System.out.printf("\n You are eligible to vote in the year %d.",eligibleYear);
        }

    }

}