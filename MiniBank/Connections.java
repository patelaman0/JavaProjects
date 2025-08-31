package MiniBank;

import java.sql.*;


public class Connections {
    public static Connection functionConnection(){
        CreditCard dc = new CreditCard();

            String url ="jdbc:oracle:thin:@localhost:1521:XE";
            String name = "your_db_username";
            String password = "your_db_password";

        try{
            Connection conn = DriverManager.getConnection(url,name,password);
            String table ="BEGIN "
                    + "EXECUTE IMMEDIATE 'CREATE TABLE BankAccount ("
                    + "Name VARCHAR2(100), "
                    + "AccountNumber NUMBER PRIMARY KEY, "
                    + "Password VARCHAR2(100),"
                    + "Balance NUMBER "
                    +  ")'; "
                    + "EXCEPTION WHEN OTHERS THEN "
                    + "IF SQLCODE != -955 THEN RAISE; END IF; "
                    + "END;";

            Statement smt = conn.createStatement();
            smt.executeUpdate(table);
            //System.out.println("Database Successfully Connected");

            return conn;

        }
        catch( SQLException e){
            throw new RuntimeException(e);

        }

    }


}
